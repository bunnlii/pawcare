package com.pawcare.entity;

import com.pawcare.providerservice.ProvService;
import jakarta.persistence.*;
import com.pawcare.entity.Customer;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "provider_id", insertable = false, updatable = false)
    private ProvService service;

    // Foreign keys (for flexibility)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "provider_id")
    private Long providerId;

    // Review data
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDateTime createdAt;

    private boolean isFlagged;

    // Constructors
    public Review() {}

    public Review(String comment, int rating, Long customerId, Long providerId, boolean isFlagged) {
        this.comment = comment;
        this.rating = rating;
        this.customerId = customerId;
        this.providerId = providerId;
        this.isFlagged = isFlagged;
    }

    public Review(String comment, int rating, Customer customer, ProvService service, boolean isFlagged) {
        this.comment = comment;
        this.rating = rating;
        this.customer = customer;
        this.service = service;
        this.customerId = customer != null ? customer.getId() : null;
        this.providerId = service != null ? service.getId() : null;
        this.isFlagged = isFlagged;
    }

    // Set timestamp automatically
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customerId = customer != null ? customer.getId() : null;
    }

    public ProvService getService() { return service; }
    public void setService(ProvService service) {
        this.service = service;
        this.providerId = service != null ? service.getId() : null;
    }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public Long getProviderId() { return providerId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public boolean isFlagged() { return isFlagged; }
    public void setFlagged(boolean flagged) { isFlagged = flagged; }
}
