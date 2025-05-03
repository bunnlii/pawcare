package com.Pawcare.Reviews;

import com.Pawcare.provider.Provider;
import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
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

    //relationship
    @ManyToOne
    @JoinColumn(name = "providerID")
    private Provider provider;

    //constructors
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

    //gets and sets
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
