package com.Pawcare._0.provider;

import com.Pawcare._0.Service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository ProviderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Provider> getAllProvider() {
        return ProviderRepository.findAll();
    }

    public Provider getProviderById(int providerID) {

        return ProviderRepository.findById(providerID).orElse(null);
    }

    public void addNewProvider(Provider provider) {
        ProviderRepository.save(provider);
    }

    public void updateProvider(int providerID, Provider provider) {
        Provider existing = getProviderById(providerID);
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

}
