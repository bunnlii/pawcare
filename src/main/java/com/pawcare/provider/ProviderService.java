package com.pawcare.provider;

import com.pawcare.providerservice.ProvServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class ProviderService {

    @Autowired
    private ProviderRepository ProviderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProvServiceRepository serviceRepository;

    public List<Provider> getAllProvider() {
        return ProviderRepository.findAll();
    }

    public Provider getProviderByID(int providerID) {

        return ProviderRepository.findById(providerID).orElse(null);
    }

    public void addNewProvider(Provider provider) {
        provider.setPassword(passwordEncoder.encode(provider.getPassword()));
        ProviderRepository.save(provider);
    }

    public void updateProvider(int providerID, Provider provider) {
        Provider existing = getProviderByID(providerID);
        existing.setName(provider.getName());
        existing.setBio(provider.getBio());
        existing.setEmail(provider.getEmail());
        existing.setUsername(provider.getUsername());
        existing.setPassword(provider.getPassword());

        ProviderRepository.save(existing);
    }

    public void deleteById(int providerID) {
        ProviderRepository.deleteById(providerID);
    }

    public Provider getProviderByUsername(String username) {
        return ProviderRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Provider not found"));
    }

    public void save(Provider provider) {
        ProviderRepository.save(provider);
    }

}
