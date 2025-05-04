package com.Pawcare.entity;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    public Pet() {}

    public Pet(String name, String type, String breed, int age, Customer customer) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.customer = customer;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
