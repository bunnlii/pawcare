package com.pawcare.service;

import com.Pawcare._0.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllService() {
        return ServiceRepository.findAll();
    }

    public Service getServiceByID(int serviceID) {

        return ServiceRepository.findById(serviceID).orElse(null);
    }

    public void deleteServiceByID(int serviceID) {
        ServiceRepository.deleteById(serviceID);
    }

    public void updateService(int serviceID, Service service) {
        Service existing = getServiceByID(serviceID);
        existing.setServiceID(service.getServiceID());
        existing.setServiceType(service.getServiceType());
        existing.setPrice(service.getPrice());
        existing.setDetails(service.getDetails());
        existing.setLocation(service.getLocation());

        ServiceRepository.save(existing);
    }
}
