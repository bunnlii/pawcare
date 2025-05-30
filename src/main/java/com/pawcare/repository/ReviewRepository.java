package com.pawcare.repository;

import com.pawcare.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByServiceServiceID(Long serviceID); // <-- match ProvService.getServiceID()
}
