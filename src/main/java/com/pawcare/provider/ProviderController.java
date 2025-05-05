package com.pawcare.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")


public class ProviderController {

    @Autowired
    private ProviderService service;

    @GetMapping("/all")
    public Object getAllProvider(Model model) {
        model.addAttribute("providerList", service.getAllProvider());
        model.addAttribute("title", "All Providers");
        return "provider-list";
    }

    @GetMapping("/{providerID}")
    public Object getProviderByID(@PathVariable int providerID, Model model) {
        model.addAttribute("provider", service.getProviderByID(providerID));
        model.addAttribute("title", "Provider #: " + providerID);
        return "provider-details";
    }


    @PostMapping("/new")
    public Object addNewProvider(@ModelAttribute Provider provider) {
        Provider savedProvider = service.addNewProvider(provider);
        return "redirect:/provider/" + savedProvider.getProviderID();
    }


    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Provider provider = new Provider();
        model.addAttribute("provider", provider);
        model.addAttribute("title", "Create New Provider");
        return "provider-create";
    }


    @GetMapping("/update/{providerID}")
    public Object updateProvider(@PathVariable int providerID, Model model) {
        model.addAttribute("provider", service.getProviderByID(providerID));
        model.addAttribute("title", "Update Provider");
        return "provider-update";
    }

    @PostMapping("/update/{providerID}")
    public Object updateProvider(@PathVariable int providerID, Provider provider) {
        service.updateProvider(providerID, provider);
        return "redirect:/provider/" + providerID;
    }

    @GetMapping("/delete/{providerID}")
    public Object deleteProviderById(@PathVariable int providerID) {
        service.deleteById(providerID);
        return "redirect:/provider/all";
    }

}
