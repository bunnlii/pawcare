package com.pawcare.demo.repository;

import com.pawcare.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByIsFlaggedTrue();
    List<Review> findByIsFlagged(boolean isFlagged);
    List<Review> findByProviderId(Long providerId);
}
