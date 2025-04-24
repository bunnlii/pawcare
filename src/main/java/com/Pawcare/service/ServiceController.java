package com.pawcare.service;

import com.pawcare.Provider.Provider;
import com.pawcare.Provider.ProviderRepository;
import com.pawcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService service;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ServiceRepository serviceRepository;


    @PostMapping("/{providerID}/add-service")
    public String addServiceToProvider(@PathVariable int providerID, @ModelAttribute Service service) {
        Provider provider = providerRepository.findById(providerID).orElse(null);
        service.setProvider(provider);
        serviceRepository.save(service);
        return "redirect:/service/all";
    }


    @GetMapping("/{providerID}/serviceForm")
    public String showCreateServiceForm(@PathVariable int providerID, Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        model.addAttribute("providerID", providerID);
        model.addAttribute("title", "Create New Service");
        return "service-create";
    }

    @GetMapping("/all")
    public String getAllService(Model model) {
        model.addAttribute("serviceList", service.getAllService());
        model.addAttribute("title", "All Services");
        return "service-list";
    }

    @GetMapping("/{serviceID}")
    public Object getServiceByID(@PathVariable int serviceID, Model model) {
        model.addAttribute("service", service.getServiceByID(serviceID));
        model.addAttribute("title", "Service #: " + serviceID);
        return "service-details";
    }

    @GetMapping("/delete/{serviceID}")
    public Object deleteServiceByID(@PathVariable int serviceID) {
        service.deleteServiceByID(serviceID);
        return "redirect:/service/all";
    }

    @PostMapping("/update/{serviceID}")
    public Object updateService(@PathVariable int serviceID, Service service) {
        return "redirect:/service/" + serviceID;
    }
}
