package com.pawcare.demo.Controller;

import com.pawcare.demo.model.Review;
import com.pawcare.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@Controller
@RequestMapping("/admin/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/all-reviews")
    public String getAllReviews(Model model) {
        List<Review> allReviews = reviewRepository.findAll();
        model.addAttribute("allReviews", allReviews);
        return "allReviews";
    }

    @GetMapping("/flagged-reviews")
    public String getFlaggedReviews(Model model) {
        List<Review> flaggedReviews = reviewRepository.findByIsFlagged(true);
        model.addAttribute("flaggedReviews", flaggedReviews);
        return "flaggedReviewsPage";
    }

    @PutMapping("/{id}/dismiss")
    public ResponseEntity<String> dismissReview(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setIsFlagged(false);
            reviewRepository.save(review);
            return ResponseEntity.ok("Review dismissed.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewRepository.deleteById(id);
            return ResponseEntity.ok("Review deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
    }

    @PutMapping("/{id}/flag")
    public ResponseEntity<String> flagReview(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setIsFlagged(true);
            reviewRepository.save(review);
            return ResponseEntity.ok("Review flagged.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
    }
}
