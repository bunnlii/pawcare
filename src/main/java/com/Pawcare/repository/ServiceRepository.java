package com.pawcare.repository;

import com.pawcare.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // List<Service> findByProviderId(Long providerId);
}
