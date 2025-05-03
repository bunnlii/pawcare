package com.Pawcare.providerservice;

import com.Pawcare.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvServiceRepository extends JpaRepository<ProvService, Integer> {

}

