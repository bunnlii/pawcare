package com.Pawcare.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public Optional<Statistics> getStatisticsByProviderId(int providerID) {
        return statisticsRepository.findByProvider_ProviderID(providerID);
    }
}

