package com.pawcare.service;

import com.pawcare.Provider.Provider;
import com.pawcare.Provider.ProviderRepository;
import com.pawcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService service;

    @GetMapping("/all")
    public Object getAllService() {
        return new ResponseEntity<>(service.getAllService(), HttpStatus.OK);
    }

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/{providerID}/add-service")
    public ResponseEntity<String> addServiceToProvider(
            @PathVariable int providerID,
            @RequestBody Service service) {
        Provider provider = providerRepository.findById(providerID).orElse(null);
        service.setProvider(provider);
        serviceRepository.save(service);
        return new ResponseEntity<>("Service added successfully", HttpStatus.CREATED);
    }
}
