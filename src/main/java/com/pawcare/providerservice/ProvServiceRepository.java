package com.pawcare.providerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvServiceRepository extends JpaRepository<ProvService, Integer> {


    List<ProvService> findByServiceTypeContainingIgnoreCaseOrDetailsContainingIgnoreCase(String serviceType, String details);

}

