package com.Pawcare._0.Statistics;

import com.Pawcare._0.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsRepository StatisticsRepository;

    public List<Statistics> getStatistics() {
        return StatisticsRepository.findAll();
    }
    }

