package com.Pawcare._0.Reviews;

import com.Pawcare._0.Service.Service;
import com.Pawcare._0.Statistics.Statistics;
import com.Pawcare._0.provider.Provider;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

public class Reviews {

    //items
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int reviewID;
    @Column(nullable = false)
    public String reviewMsg;
    @Column(nullable = false)
    public int reviewRating;
    public String reviewResponse;

    @ManyToOne
    @JoinColumn(name = "providerID")
    private Provider provider;

    public Reviews(){
    }

    public Reviews(int reviewID, String reviewMsg, int reviewRating, String reviewResponse){
        this.reviewID = reviewID;
        this.reviewMsg = reviewMsg;
        this.reviewRating = reviewRating;
        this.reviewResponse = reviewResponse;
    }

    public Reviews(int reviewID, String reviewMsg, int reviewRating){
        this.reviewID = reviewID;
        this.reviewMsg = reviewMsg;
        this.reviewRating = reviewRating;
    }

    public int getReviewID(){
        return  reviewID;
    }
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewMsg(){
        return reviewMsg;
    }
    public void setReviewMsg(String reviewMsg) {
        this.reviewMsg = reviewMsg;
    }

    public int getReviewRating(){
        return reviewRating;
    }
    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewResponse(){
        return reviewResponse;
    }
    public void setReviewResponse(String reviewResponse) {
        this.reviewResponse = reviewResponse;
    }

}
