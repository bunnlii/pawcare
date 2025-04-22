package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Service;
import com.pawcare.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    //view list of services
    @GetMapping("/services")
    public String showServices(Model model) {
        List<Service> services = new ArrayList<>();
        services.add(new Service("grooming", "Grooming", "Our grooming service will keep your pet looking fresh and clean. We offer full grooming packages including bath, trim, and nail clipping for all pets.", "/images/pet_groom.svg"));
        services.add(new Service("vet", "Veterinary Care", "We provide full veterinary care for your pet, including routine checkups, vaccinations, and emergency services.", "/images/pet_vet.svg"));
        services.add(new Service("sitting", "Pet Sitting", "Going away? Our pet sitting service provides care and attention to your pets while you're away.", "/images/pet_sit.svg"));
        services.add(new Service("walking", "Pet Walking", "Ensure your pet gets exercise and fresh air with our regular walking services.", "/images/pet_walk.svg"));
        services.add(new Service("training", "Pet Training", "Our certified trainers offer a range of obedience and behavioral training for pets of all ages.", "/images/pet_train.svg"));
        services.add(new Service("adoption", "Adoption Assistance", "We help facilitate pet adoptions by connecting you with rescue organizations and shelters.", "/images/pet_adopt.svg"));

        model.addAttribute("services", services);
        return "customer/services";
    }
    //sevices details
    @GetMapping("/services/{id}")
    public String showServiceDetail(@PathVariable String id, Model model) {
        Map<String, Service> serviceMap = new HashMap<>();
        serviceMap.put("grooming", new Service("grooming", "Grooming", "Our grooming service will keep your pet looking fresh and clean. We offer full grooming packages including bath, trim, and nail clipping for all pets.", "/images/pet_groom.svg"));
        serviceMap.put("vet", new Service("vet", "Veterinary Care", "We provide full veterinary care for your pet, including routine checkups, vaccinations, and emergency services.", "/images/pet_vet.svg"));
        serviceMap.put("sitting", new Service("sitting", "Pet Sitting", "Going away? Our pet sitting service provides care and attention to your pets while you're away.", "/images/pet_sit.svg"));
        serviceMap.put("walking", new Service("walking", "Pet Walking", "Ensure your pet gets exercise and fresh air with our regular walking services.", "/images/pet_walk.svg"));
        serviceMap.put("training", new Service("training", "Pet Training", "Our certified trainers offer a range of obedience and behavioral training for pets of all ages.", "/images/pet_train.svg"));
        serviceMap.put("adoption", new Service("adoption", "Adoption Assistance", "We help facilitate pet adoptions by connecting you with rescue organizations and shelters.", "/images/pet_adopt.svg"));

        Service selected = serviceMap.get(id);
        model.addAttribute("service", selected);
        model.addAttribute("booking", new Booking());
        return "customer/serviceDetail";
    }

    //book a service
    @PostMapping("/services/{id}/book")
    public String bookService(@PathVariable String id, @ModelAttribute Booking booking) {
        booking.setServiceType(id);
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


