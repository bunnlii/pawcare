package com.pawcare.controller;

import com.pawcare.entity.Booking;
import com.pawcare.entity.Customer;
import com.pawcare.entity.Pet;
import com.pawcare.entity.Review;

import com.pawcare.providerservice.ProvService;
import com.pawcare.providerservice.ProvServiceRepository;
import com.pawcare.repository.BookingRepository;
import com.pawcare.repository.PetRepository;
import com.pawcare.repository.ReviewRepository;
import com.pawcare.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


    @GetMapping("/services")
    public String showAllServices(Model model) {
        List<ProvService> services = provServiceRepository.findAll();
        model.addAttribute("services", services);
        return "service-list";
    }

    // Home page showing services
    @GetMapping("/index")
    public String home(Model model) {
        List<ProvService> services = provServiceRepository.findAll();
        model.addAttribute("services", services);
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-signup";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer) {
        if (customer.getRole() == null || customer.getRole().trim().isEmpty()) {
            customer.setRole("ROLE_USER");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
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

    @GetMapping("/customers/edit/{id}")
    public String showEditProfileForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "redirect:/customers/index";
        }
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @PostMapping("/edit/{customerID}")
    public String updateCustomer(@PathVariable Long customerID, @ModelAttribute Customer updatedCustomer) {
        customerService.updateCustomer(customerID, updatedCustomer);
        return "redirect:/customers/profile";
    }


   /** @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "login";
        }
        model.addAttribute("customer", customer);
        return "customer-profile";
    }**/

   @GetMapping("/profile/{id}")
   public String viewProfile(@PathVariable("id") Long id, Model model) {
       Customer customer = customerService.getCustomerById(id);
       if (customer == null) {
           return "login";
       }

       List<Booking> bookings = bookingRepository.findByCustomerId(id);
       List<Review> reviews = customer.getReviews();
       model.addAttribute("reviews", reviews);
       model.addAttribute("customer", customer);
       model.addAttribute("bookings", bookings);
       return "customer-profile";
   }


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

    @GetMapping("/reviews")
    public String showReviewsPage(Model model) {
        List<Review> reviews = reviewRepository.findAll(); // or findByServiceId if specific
        model.addAttribute("reviews", reviews);
        return "add-review";
    }
    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Customer customer = customerService.findByEmail(userDetails.getUsername());
        model.addAttribute("customer", customer);
        return "customer-dashboard";
    }

}
