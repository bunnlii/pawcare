package com.pawcare.controller;
import com.pawcare.entity.Booking;
import org.springframework.http.ResponseEntity;
import com.pawcare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/customer")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/services")
    public String showServices(Model model) {
        System.out.println("service hit");
        return "customer/services";
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
