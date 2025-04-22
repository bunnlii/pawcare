package com.Pawcare._0.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/{providerID}")
    public ResponseEntity<Object> getStatisticsByProviderId(@PathVariable int providerID) {
        Optional<Statistics> statistics = statisticsService.getStatisticsByProviderId(providerID);

        if (statistics.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "No statistics found for provider ID: " + providerID
            );
        }

        return ResponseEntity.ok(statistics.get());
    }
}


