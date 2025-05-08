package com.pawcare.security;

import com.pawcare.security.CustomerUserDetailsService;
import com.pawcare.security.CustomProviderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.*;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private CustomProviderDetailsService customProviderDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ Provide both authentication providers
    @Bean
    public AuthenticationManager authenticationManager(
            DaoAuthenticationProvider customerAuthenticationProvider,
            DaoAuthenticationProvider providerAuthenticationProvider
    ) {
        return new ProviderManager(List.of(customerAuthenticationProvider, providerAuthenticationProvider));
    }

    @Bean
    public DaoAuthenticationProvider customerAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider providerAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customProviderDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    // ✅ Main security config
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/customers/loginn", "/customers/login","/css/**", "/js/**","/image/**").permitAll()
                .requestMatchers("/customers/**").hasRole("USER")
                .requestMatchers("/provider/**").hasRole("PROVIDER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customers/loginn")
                .loginProcessingUrl("/login") // default Spring Security POST URL
                .defaultSuccessUrl("/customers/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/customers/loginn")
                .permitAll();

        return http.build();
    }
}
