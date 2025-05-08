package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Customer;
import com.pawcare.provider.ProviderRepository;
import com.pawcare.providerservice.ProvService;
import com.pawcare.providerservice.ProvServiceRepository;
import com.pawcare.repository.BookingRepository;

import com.pawcare.repository.CustomerRepository;
import com.pawcare.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/customer")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

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
    public String showBooking(@RequestParam("serviceId") Integer serviceId, Model model, Principal principal) {
        ProvService service = provServiceRepository.findById(serviceId).orElse(null);
        Customer customer = customerService.findByUsername(principal.getName());
        Booking booking = new Booking();
        booking.setService(service);

        model.addAttribute("booking", booking);
        model.addAttribute("service", service);
        model.addAttribute("customer", customer);
        model.addAttribute("pets", customer.getPets());
        return "bookingService"; // this is your booking form view
    }


    @PostMapping("/bookingServices")
    public String submitBooking(@ModelAttribute Booking booking, @RequestParam("serviceID") Integer serviceId) {
        ProvService service = provServiceRepository.findById(serviceId).orElse(null);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Customer customer = customerRepository.findByUsername(username);

        booking.setService(service);
        booking.setCustomer(customer);
        bookingRepository.save(booking);

        Long customerId = customer.getId();  // no longer null ✅

        return "redirect:/customer/confirmation?serviceId=" + serviceId + "&customerId=" + customerId;
    }

    @GetMapping("/bookings/edit/{id}")
    public String showEditBookingForm(@PathVariable("id") Long id, Model model) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            return "redirect:/customer/profile"; // fallback
        }

        model.addAttribute("booking", booking);
        return "edit-booking";
    }

    @PostMapping("/bookings/edit/{id}")
    public String updateBooking(@PathVariable("id") Long id, @ModelAttribute Booking updatedBooking) {
        Booking existing = bookingRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setAppointmentDate(updatedBooking.getAppointmentDate());
            existing.setPetName(updatedBooking.getPetName());
            bookingRepository.save(existing);
        }
        return "redirect:/customer/profile/" + existing.getCustomer().getId();
    }

    @GetMapping("/bookings/delete/{id}")
    public String deleteBooking(@PathVariable("id") Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking != null) {
            Long customerId = booking.getCustomer().getId();
            bookingRepository.deleteById(id);
            return "redirect:/customers/profile/" + customerId;
        }

        return "redirect:/customers/index";
    }


    @GetMapping("/confirmation")
    public String showConfirmation(@RequestParam("serviceId") Integer serviceId,
                                   @RequestParam("customerId") Long customerId,
                                   Model model) {
        model.addAttribute("serviceId", serviceId);
        model.addAttribute("customerId", customerId);
        return "confirmation";
    }

}


