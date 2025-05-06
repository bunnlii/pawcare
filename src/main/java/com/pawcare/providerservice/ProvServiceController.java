package com.pawcare.providerservice;

import com.pawcare.provider.Provider;
import com.pawcare.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/service")
public class ProvServiceController {
    @Autowired
    private ProvServiceService service;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProvServiceRepository serviceRepository;


    @PostMapping("/{providerID}/add-service")
    public String addServiceToProvider(@PathVariable int providerID, @ModelAttribute ProvService service) {
        Provider provider = providerRepository.findById(providerID).orElse(null);
        service.setProvider(provider);
        serviceRepository.save(service);
        return "redirect:/service/" + service.getServiceID();
    }


    @GetMapping("/{providerID}/serviceForm")
    public String showCreateServiceForm(@PathVariable int providerID, Model model) {
        Provider provider = service.getProviderByID(providerID); // your service class
        if (provider == null) {
            throw new RuntimeException("Provider not found with ID: " + providerID);
        }

        ProvService newService = new ProvService();
        model.addAttribute("service", newService);
        model.addAttribute("provider", provider);
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


    @GetMapping("/update/{serviceID}")
    public Object updateProvider(@PathVariable int serviceID, Model model) {
        model.addAttribute("service", service.getServiceByID(serviceID));
        model.addAttribute("title", "Update Service");
        return "service-update";
    }
}
