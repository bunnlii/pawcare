package com.pawcare.providerservice;

import com.pawcare.provider.Provider;
import com.pawcare.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


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
    public String addServiceToProvider(@PathVariable int providerID,
                                       @ModelAttribute ProvService service) {
        Provider provider = providerRepository.findById(providerID).orElse(null);

        service.setProvider(provider);
        ProvService savedService = serviceRepository.save(service);

        return "redirect:/service/" + providerID + "/"+ savedService.getServiceID();
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

    @GetMapping("/view/{id}")
    public String viewService(@PathVariable("id") Integer id, Model model) {
        ProvService service = serviceRepository.findById(id).orElse(null);
        if (service == null) {
            return "redirect:/error";
        }
        model.addAttribute("service", service);
        return "customerservice-details";
    }



    @GetMapping("/provider/{providerID}/{serviceID}")
    public Object getServiceByID(@PathVariable int serviceID,
                                 @PathVariable int providerID,
                                 Model model) {
        model.addAttribute("service", service.getServiceByID(serviceID));
        model.addAttribute("provider", service.getProviderByID(providerID));
        model.addAttribute("title", "Service #: " + serviceID);
        return "providerservice-details";
    }


    @GetMapping("/delete/{providerID}/{serviceID}")
    public String deleteServiceByID(@PathVariable int providerID,
                                    @PathVariable int serviceID) {
        service.deleteServiceByID(serviceID);
        return "redirect:/provider/" + providerID + "/services";
    }



    @GetMapping("/update/form/{serviceID}/{providerID}")
    public Object showServiceForm(@PathVariable int serviceID, @PathVariable int providerID, Model model) {
        model.addAttribute("service", service.getServiceByID(serviceID));
        model.addAttribute("provider", service.getProviderByID(providerID));
        model.addAttribute("title", "Update Service");
        return "service-update";
    }

    @PostMapping("/update/{serviceID}/{providerID}")
    public Object updateService(@PathVariable int serviceID, ProvService provservice, @PathVariable int providerID, Model model) {
        service.updateService(serviceID, provservice);
        return "redirect:/service/" + providerID + "/" + serviceID;
    }

}
