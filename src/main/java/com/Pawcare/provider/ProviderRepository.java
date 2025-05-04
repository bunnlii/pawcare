package com.Pawcare.provider;

import com.Pawcare.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

//    List<Provider> findByService(Service service);
}

