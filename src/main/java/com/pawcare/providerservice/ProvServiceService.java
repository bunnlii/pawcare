package com.pawcare.providerservice;

import com.pawcare.provider.Provider;
import com.pawcare.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvServiceService {

    @Autowired
    private ProvServiceRepository serviceRepository;


    public List<ProvService> getAllService() {
        return serviceRepository.findAll();
    }

    public ProvService getServiceByID(int serviceID) {
        return serviceRepository.findById(serviceID).orElse(null);
    }

    public void updateService(int serviceID, ProvService service) {
        ProvService existing = getServiceByID(serviceID);
        if (existing != null) {
            existing.setServiceType(service.getServiceType());
            existing.setPrice(service.getPrice());
            existing.setDetails(service.getDetails());
            existing.setLocation(service.getLocation());
            existing.setProvider(service.getProvider());

            serviceRepository.save(existing);
        }
    }
    public List<ProvService> searchByKeyword(String keyword) {
        return serviceRepository.findByServiceTypeContainingIgnoreCaseOrDetailsContainingIgnoreCase(keyword, keyword);
    }


    public void deleteServiceByID(int serviceID) {
        serviceRepository.deleteById(serviceID);
    }

    @Autowired
    private ProviderRepository providerRepository;

    public Provider getProviderByID(int id) {
        return providerRepository.findById(id).orElse(null);
    }
}


