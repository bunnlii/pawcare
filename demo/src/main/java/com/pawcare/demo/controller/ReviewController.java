package com.pawcare.demo.controller;

import com.pawcare.demo.model.Review;
import com.pawcare.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/flagged")
    public List<Review> getFlaggedReviews() {
        return reviewRepository.findByIsFlagged(true);
    }

    @PutMapping("/{id}/dismiss")
    public ResponseEntity<String> dismissReport(@PathVariable Long id) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setIsFlagged(false);
            reviewRepository.save(review);
            return ResponseEntity.ok("Report dismissed");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
    }
}
