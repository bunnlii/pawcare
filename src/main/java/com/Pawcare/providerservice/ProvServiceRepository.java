package com.Pawcare.providerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvServiceRepository extends JpaRepository<ProvService, Integer> {

}

