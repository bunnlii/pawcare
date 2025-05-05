package com.pawcare.entity;

import jakarta.persistence.*;


@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private String description;
    private String imagePath;

    public Service() {}


    public Service(String title, double price, String description, String imagePath) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Service(Long id, String title, double price, String description, String imagePath) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}

