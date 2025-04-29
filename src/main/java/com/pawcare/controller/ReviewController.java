package com.pawcare.controller;

import com.pawcare.entity.Review;
import com.pawcare.entity.Service;
import com.pawcare.repository.ReviewRepository;
import com.pawcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services/{id}/review")
    public String showReviewForm(@PathVariable Long id, Model model) {
        model.addAttribute("serviceId", id);
        model.addAttribute("review", new Review());
        return "customer/review";
    }

    @PostMapping("/services/{id}/review")
    public String submitReview(@PathVariable Long id, @ModelAttribute Review review) {
        Service service = serviceRepository.findById(id).orElse(null);
        if (service != null) {
            review.setService(service);
            reviewRepository.save(review);
        }
        return "redirect:/customer/services";
    }
}

