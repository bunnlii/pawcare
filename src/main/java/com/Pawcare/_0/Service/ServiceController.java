package com.Pawcare._0.Service;

import com.Pawcare._0.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")

public class ServiceController {
    @Autowired
    private ServiceService service;

    @GetMapping("/all")
    public Object getAllService() {
        return new ResponseEntity<>(service.getAllService(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewService(@RequestBody Service Service) {
        service.addNewService(Service);
        return new ResponseEntity<>(service.getAllService(), HttpStatus.CREATED);
    }
}
