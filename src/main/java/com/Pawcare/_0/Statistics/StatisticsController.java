package com.Pawcare._0.Statistics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")

public class StatisticsController {
    @GetMapping("/all")
    public Object getStatistics() {
        return new ResponseEntity<>(getStatistics().getClass(), HttpStatus.OK);
    }

}
