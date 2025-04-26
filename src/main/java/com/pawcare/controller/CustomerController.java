package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Customer;
import com.pawcare.repository.BookingRepository;
import com.pawcare.repository.PetRepository;
import com.pawcare.repository.ServiceRepository;
import com.pawcare.repository.ReviewRepository;
import com.pawcare.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-signup";  // Match your ftlh file
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "customer-login";
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model) {
        Customer customer = customerService.findByEmail(email);

        if (customer == null) {
            model.addAttribute("errorMessage", "No account found with that email.");
            return "customer-login";
        }

        if (!customer.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "Incorrect password. Please try again.");
            return "customer-login";
        }

        model.addAttribute("customer", customer);
        return "customer-dashboard";
    }

    @GetMapping("/appointments")
    public String viewAppointments(@RequestParam("customerId") Long customerId, Model model) {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
        model.addAttribute("bookings", bookings);
        return "appointments";
    }
    @GetMapping("/edit/{id}")
    public String showEditProfileForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "redirect:/customer/dashboard";
        }
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @PostMapping("/edit/{id}")
    public String updateProfile(@PathVariable("id") Long id, @ModelAttribute("customer") Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
        return "redirect:/customers/dashboard";
    }

    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "error";
        }
        model.addAttribute("customer", customer);
        return "customer-profile";
    }

    @GetMapping("/add-pet/{customerId}")
    public String showAddPetForm(@PathVariable("customerId") Long customerId, Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("customerId", customerId);
        return "add_pet";  // Go to add_pet.ftlh
    }


    @PostMapping("/add-pet/{customerId}")
    public String addPet(@PathVariable("customerId") Long customerId, @ModelAttribute("pet") Pet pet) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            pet.setCustomer(customer);
            petRepository.save(pet);
        }
        return "redirect:/customers/profile/" + customerId;  // After adding, go back to profile
    }

    @GetMapping("/add-review/{serviceId}/{customerId}")
    public String showAddReviewForm(@PathVariable("serviceId") Long serviceId,
                                    @PathVariable("customerId") Long customerId, Model model) {
        Review review = new Review();
        model.addAttribute("review", review);
        model.addAttribute("serviceId", serviceId);
        model.addAttribute("customerId", customerId);
        return "add_review";
    }

    // Save Review
    @PostMapping("/add-review/{serviceId}/{customerId}")
    public String addReview(@PathVariable("serviceId") Long serviceId,
                            @PathVariable("customerId") Long customerId,
                            @ModelAttribute("review") Review review) {
        Customer customer = customerService.getCustomerById(customerId);
        Service service = serviceRepository.getById(serviceId); // You should have ServiceRepository

        if (customer != null && service != null) {
            review.setCustomer(customer);
            review.setService(service);
            reviewRepository.save(review);
        }
        return "redirect:/services";  // After review, redirect to services
    }

}
