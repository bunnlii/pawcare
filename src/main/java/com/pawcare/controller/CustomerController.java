package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Customer;
import com.pawcare.entity.Pet;
import com.pawcare.entity.Review;
import com.pawcare.provider.Provider;
import com.pawcare.providerservice.ProvService;
import com.pawcare.providerservice.ProvServiceRepository;
import com.pawcare.repository.BookingRepository;
import com.pawcare.repository.PetRepository;
import com.pawcare.repository.ReviewRepository;
import com.pawcare.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProvServiceRepository provServiceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingRepository bookingRepository;

    // ============ REGISTER ============
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-signup";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer) {
        if (customer.getRole() == null || customer.getRole().trim().isEmpty()) {
            customer.setRole("USER");
        }

        // Encrypt the password
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        // Save the customer
        customerService.saveCustomer(customer);

        // Re-fetch the customer to get the generated ID
        Customer savedCustomer = customerService.findByUsername(customer.getUsername());

        // Redirect to profile page
        return "redirect:/customers/profile/" + savedCustomer.getId();
    }



    // ============ LOGIN PAGE ============
    @GetMapping("/loginn")
    public String showLoginForm() {
        return "customer-login";
    }

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }


    // ============ DASHBOARD (AFTER LOGIN) ============
    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/customers/loginn";
        }

        Customer customer = customerService.findByUsername(userDetails.getUsername());
        if (customer == null) {
            return "redirect:/customers/loginn";
        }

        model.addAttribute("customer", customer);
        return "customer-dashboard"; // or whatever your .ftlh file is called
    }



    // ============ HOME REDIRECT ============
    @GetMapping("/home")
    public String showCustomerHome() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = customerService.findByUsername(username);
        return "redirect:/customers/profile/" + customer.getId();
    }

    // ============ PROFILE VIEW ============
    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "redirect:/customers/loginn";
        }
        List<Booking> bookings = bookingRepository.findByCustomerId(id);
        List<Review> reviews = customer.getReviews();

        model.addAttribute("customer", customer);
        model.addAttribute("reviews", reviews);
        model.addAttribute("bookings", bookings);
        return "customer-profile";
    }

    // ============ EDIT PROFILE ============
    @GetMapping("/edit/{id}")
    public String showEditProfileForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "redirect:/customers/loginn";
        }
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
        return "redirect:/customers/profile/" + id;
    }

    // ============ DELETE ACCOUNT ============
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/index";
    }


    // ============ VIEW SERVICES ============
    @GetMapping("/index")
    public String home(Model model) {
        List<ProvService> services = provServiceRepository.findAll();
        List<Review> reviews = reviewRepository.findAll();

        model.addAttribute("services", services);
        model.addAttribute("reviews", reviews);
        return "index";
    }

    // ============ ADD PET ============
    @GetMapping("/add-pet/{customerId}")
    public String showAddPetForm(@PathVariable("customerId") Long customerId, Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("customerId", customerId);
        return "add-pet";
    }

    @PostMapping("/add-pet/{customerId}")
    public String addPet(@PathVariable("customerId") Long customerId, @ModelAttribute("pet") Pet pet) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            pet.setCustomer(customer);
            petRepository.save(pet);
        }
        return "redirect:/customers/profile/" + customerId;
    }

    // ============ ADD REVIEW ============
    @GetMapping("/add-review/{serviceId}/{customerId}")
    public String showAddReviewForm(@PathVariable("serviceId") Long serviceId,
                                    @PathVariable("customerId") Long customerId, Model model) {
        Review review = new Review();
        model.addAttribute("review", review);
        model.addAttribute("serviceId", serviceId);
        model.addAttribute("customerId", customerId);
        return "add-review";
    }

    @PostMapping("/add-review/{serviceId}/{customerId}")
    public String addReview(@PathVariable("serviceId") Integer serviceId,
                            @PathVariable("customerId") Long customerId,
                            @ModelAttribute("review") Review review) {
        Customer customer = customerService.getCustomerById(customerId);
        ProvService service = provServiceRepository.findById(serviceId).orElse(null);

        if (customer != null && service != null) {
            review.setCustomer(customer);
            review.setService(service);
            reviewRepository.save(review);
        }
        return "redirect:/customers/index";
    }

    // ============ VIEW BOOKINGS ============
    @GetMapping("/appointments")
    public String viewAppointments(@RequestParam("customerId") Long customerId, Model model) {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
        model.addAttribute("bookings", bookings);
        return "appointments";
    }

    // ============ ALL REVIEWS PAGE ============
    @GetMapping("/reviews")
    public String showReviewsPage(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "add-review";
    }
}
