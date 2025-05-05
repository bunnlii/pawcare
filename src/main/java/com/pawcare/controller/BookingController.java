package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Service;
import com.pawcare.provider.ProviderRepository;
import com.pawcare.repository.BookingRepository;
import com.pawcare.provider.Provider;

import com.pawcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/customer")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProviderRepository providerRepository;


    //view list of services
    @GetMapping("/services")
    public String showServices(Model model) {
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "customer/services";
    }

//    //sevices details
//    @GetMapping("/services/{id}")
//    public String showServiceDetail(@PathVariable Long id, Model model) {
//        Optional<Service> serviceOptional = serviceRepository.findById(id);
//        if (serviceOptional.isPresent()) {
//            Service service = serviceOptional.get();
//            List<Provider> providers = providerRepository.findByService(service);
//
//            model.addAttribute("service", service);
//            model.addAttribute("providers", providers);
//            model.addAttribute("booking", new Booking());
//
//            return "customer/serviceDetail";
//        } else {
//            return "redirect:/customer/services";
//        }
//    }

    //book a service
    @PostMapping("/services/{id}/book")
    public String bookService(@PathVariable Long id, @ModelAttribute Booking booking) {
        Service service = serviceRepository.findById(id).orElse(null);
        booking.setService(service);
        bookingRepository.save(booking);
        return "redirect:/customer/confirmation";
    }
    @GetMapping("/bookingServices")
    public String showBooking(Model model) {
        model.addAttribute("booking", new Booking());
        return "customer/bookingService";
    }

    @PostMapping("/bookingServices")
    public String submitBooking(@ModelAttribute Booking booking) {
        bookingRepository.save(booking);
        return "redirect:/customer/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(Model model) {
        return "customer/confirmation";
    }
}


