package com.pawcare.demo.service;

import com.pawcare.demo.model.Review;
import com.pawcare.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getFlaggedReviews() {
        return reviewRepository.findByIsFlaggedTrue();
    }

    public String toggleFlagStatus(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Review not found."));
        review.setIsFlagged(!review.isIsFlagged());
        reviewRepository.save(review);
        return "Flag status updated.";
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
