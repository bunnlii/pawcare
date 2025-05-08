package com.pawcare.controller;

import com.pawcare.entity.Customer;
import com.pawcare.entity.Review;
import com.pawcare.providerservice.ProvService;
import com.pawcare.providerservice.ProvServiceRepository;
import com.pawcare.repository.BookingRepository;
import com.pawcare.repository.CustomerRepository;
import com.pawcare.repository.ReviewRepository;
import com.pawcare.service.CustomerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;


public class ReviewController {

    @Autowired
    private ProvServiceRepository provServiceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/add-review/{serviceId}/{customerId}")
    public String showAddReviewForm(@PathVariable("serviceId") Long serviceId,
                                    @PathVariable("customerId") Long customerId,
                                    Model model) {
        model.addAttribute("review", new Review());
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

        return "redirect:/customers/profile/" + customerId;
    }

}
