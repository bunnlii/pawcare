package com.Pawcare._0.Statistics;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    Optional<Statistics> findByProvider_ProviderID(int providerID);
}

