package com.Pawcare._0.Statistics;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Statistics {
    //items
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int statisticsID;

    @Column(nullable = false)
    public int numCustomer;
    @Column(nullable = false)
    public double avgRating;
    @Column(nullable = false)
    public int totalService;

    public Statistics(){
    }

    public Statistics(int statisticsID, int numCustomer, double avgRating, int totalService){
        this.statisticsID = statisticsID;
        this.numCustomer = numCustomer;
        this.avgRating = avgRating;
        this.totalService = totalService;
    }

    public int getStatisticsID(){
        return statisticsID;
    }
    public void setStatisticsID(int statisticsID) {
        this.statisticsID = statisticsID;
    }

    public int getNumCustomer(){
        return numCustomer;
    }
    public void setNumCustomer(int numCustomer) {
        this.numCustomer = numCustomer;
    }

    public double getAvgRating(){
        return avgRating;
    }
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getTotalService(){
        return totalService;
    }
    public void setTotalService(int totalService) {
        this.totalService = totalService;
    }
}
