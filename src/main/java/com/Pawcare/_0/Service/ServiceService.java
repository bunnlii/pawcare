package com.Pawcare._0.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository ServiceRepository;

    public List<Service> getAllService() {
        return ServiceRepository.findAll();
    }

}
