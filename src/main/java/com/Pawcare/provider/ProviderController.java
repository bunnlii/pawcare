package com.pawcare.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")


public class ProviderController {

    @Autowired
    private ProviderService service;

    @GetMapping("/all")
    public Object getAllProvider() {
        return new ResponseEntity<>(service.getAllProvider(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewProvider(@RequestBody Provider provider) {
        service.addNewProvider(provider);
        return new ResponseEntity<>(service.getAllProvider(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{providerID}")
    public Object updateProvider(@PathVariable int providerID, @RequestBody Provider provider) {
        service.updateProvider(providerID, provider);
        return new ResponseEntity<>(service.getProviderById(providerID), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{providerID}")
    public Object deleteProviderById(@PathVariable int providerID) {
        service.deleteById(providerID);
        return new ResponseEntity<>(service.getAllProvider(), HttpStatus.OK);
    }
}
