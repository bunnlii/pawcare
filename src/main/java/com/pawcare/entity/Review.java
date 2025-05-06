package com.pawcare.entity;

import com.pawcare.providerservice.ProvService;
import jakarta.persistence.*;

@Entity

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id") //, referencedColumnName = "serviceID")
    private ProvService service;

    public Review() {}

    public Review(String content, int rating, Customer customer, ProvService service) {
        this.content = content;
        this.rating = rating;
        this.customer = customer;
        this.service = service;
    }

    public Long getId() { return id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public ProvService getService() { return service; }
    public void setService(ProvService service) { this.service = service; }
}
