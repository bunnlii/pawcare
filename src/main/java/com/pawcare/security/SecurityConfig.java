package com.pawcare.security;


import com.pawcare.provider.ProviderRepository;
import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomProviderDetailsService providerDetailsService;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD,
                                DispatcherType.ERROR).permitAll()
                        .requestMatchers("/home","/provider/createForm","/provider/new", "/provider/login", "/customers/register", "/customers/login","/css/**", "/images").permitAll()
                        .requestMatchers("/services/**").hasAuthority("ROLE_PROVIDER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(form -> form
                                .loginPage("/login")                //customer login page
                                .loginProcessingUrl("/login")                 //where form submits
                                .defaultSuccessUrl("/customers/dashboard", true)  //where customer goes after login
                                .failureUrl("/customers/login?error=true")
                                .permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/provider/login")     //take out to use own but it currently doesnt work
                        .loginProcessingUrl("/provider/login")
                        .defaultSuccessUrl("/provider/home", true)
                       .failureUrl("/provider/login?error=true") // Redirect if login fails
                        .permitAll()
                );



        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);

        // Customer login
        auth.authenticationProvider(customerAuthenticationProvider());

        // Provider login
        auth.authenticationProvider(providerAuthenticationProvider());

        return auth.build();
    }
    @Bean
    public AuthenticationProvider customerAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationProvider providerAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(providerDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}