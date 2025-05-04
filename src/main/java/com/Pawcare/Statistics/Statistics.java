package com.Pawcare.Statistics;

import com.pawcare.Provider.Provider;
import jakarta.persistence.*;


@Entity
@Table(name = "statistics")
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

    @OneToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;


    public Statistics(){
    }

    public Statistics(int statisticsID, int providerID, int numCustomer, double avgRating, int totalService){
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

    @Override
    public String toString() {
        return "Statistics{" +
                "avg rating=" + avgRating +
                ", number of customer='" + numCustomer + '\'' +
                ", total service='" + totalService +
                '}';
    }
}
