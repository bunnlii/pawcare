package com.Pawcare._0.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistics")

public class StatisticsController {

    @Autowired
    private StatisticsService StatisticsService;

    @GetMapping("/all")
    public ResponseEntity<List<Statistics>> getAllStatistics() {
        List<Statistics> statisticsList = StatisticsService.getStatistics();
        return ResponseEntity.ok(statisticsList);
    }


}
