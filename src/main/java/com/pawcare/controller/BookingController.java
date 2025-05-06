package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.provider.ProviderRepository;
import com.pawcare.providerservice.ProvService;
import com.pawcare.providerservice.ProvServiceRepository;
import com.pawcare.repository.BookingRepository;

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
    private ProvServiceRepository provServiceRepository;

    @Autowired
    private ProviderRepository providerRepository;


    //view list of services
    @GetMapping("/services")
    public String showServices(Model model) {
        List<ProvService> services = provServiceRepository.findAll();
        model.addAttribute("services", services);
        return "services";
    }

//    //sevices details
//   @GetMapping("/services/{id}")
//    public String showServiceDetail(@PathVariable Integer id, Model model) {
//        Optional<ProvService> serviceOptional = provServiceRepository.findById(id);
//        if (serviceOptional.isPresent()) {
//            ProvService service = serviceOptional.get();
//
//            model.addAttribute("service", service);
//            model.addAttribute("provider", service.getProvider());
//            model.addAttribute("booking", new Booking());
//
//            return "customer/serviceDetail";
//        } else {
//            return "redirect:/customer/services";
//        }
//    }

    //book a service
    @PostMapping("/services/{id}/book")
    public String bookService(@PathVariable Integer id, @ModelAttribute Booking booking) {
        ProvService service = provServiceRepository.findById(id).orElse(null);
        booking.setService(service);
        bookingRepository.save(booking);
        return "redirect:/customer/confirmation";
    }

    @GetMapping("/bookingServices")
    public String showBooking(@RequestParam("serviceId") Integer serviceId, Model model) {
        ProvService service = provServiceRepository.findById(serviceId).orElse(null);
        Booking booking = new Booking();
        booking.setService(service);

        model.addAttribute("booking", booking);
        model.addAttribute("service", service);
        return "bookingService"; // this is your booking form view
    }


    @PostMapping("/bookingServices")
    public String submitBooking(@ModelAttribute Booking booking) {
        bookingRepository.save(booking);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(Model model) {
        return "confirmation";
    }
}


