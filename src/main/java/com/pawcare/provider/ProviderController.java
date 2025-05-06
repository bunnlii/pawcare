    package com.pawcare.provider;

    import com.pawcare.providerservice.ProvService;
    import com.pawcare.providerservice.ProvServiceService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Controller;
    import org.springframework.stereotype.Service;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @RequestMapping("/provider")


    public class ProviderController {

        @Autowired
        private ProviderService service;

        @Autowired
        private PasswordEncoder passwordEncoder;

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

        @GetMapping("/login")
        public String showLoginForm() {
            return "provider-login";
        }

        @GetMapping("/home")
        public String showProviderHome() {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Provider provider = service.getProviderByUsername(username);
            return "redirect:/provider/" + provider.getProviderID();
        }


        @PostMapping("/new")
        public String addNewProvider(@ModelAttribute Provider provider) {
            if (provider.getRole() == null || provider.getRole().trim().isEmpty()) {
                provider.setRole("ROLE_PROVIDER");
            }
            provider.setPassword(passwordEncoder.encode(provider.getPassword()));
            service.save(provider);
            return "redirect:/provider/login";
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

        @GetMapping("/{providerID}/services")
        public String viewProviderServices(@PathVariable int providerID, Model model) {
            Provider provider = service.getProviderByID(providerID);
            List<ProvService> services = provider.getServices();

            model.addAttribute("provider", provider);
            model.addAttribute("serviceList", services);

            return "my-services";
        }



//        @GetMapping("/provider/statistics/{id}")
//        public String showStatistics(@PathVariable Integer providerID, Model model) {
//            Provider provider = service.getProviderByID(providerID);
//
//            int serviceCount = provider.getServices().size();
//            int reviewCount = provider.getReviews().size();
//
//            double avgRating = provider.getReviews().stream()
//                    .mapToDouble(Reviews::getRating) // assumes getRating() returns double
//                    .average()
//                    .orElse(0.0);
//
//            model.addAttribute("provider", provider);
//            model.addAttribute("serviceCount", serviceCount);
//            model.addAttribute("reviewCount", reviewCount);
//            model.addAttribute("avgRating", avgRating);
//
//            return "provider/statistics";
//        }


    }
