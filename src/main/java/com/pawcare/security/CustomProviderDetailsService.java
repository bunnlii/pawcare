package com.pawcare.security;

import com.pawcare.provider.Provider;
import com.pawcare.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomProviderDetailsService implements UserDetailsService {

    @Autowired
    private ProviderRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Provider provider = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));


        ArrayList<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(provider.getRole()));


        return new org.springframework.security.core.userdetails.User(
                provider.getUsername(),
                provider.getPassword(),
                authList
        );
    }
}
