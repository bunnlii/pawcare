package com.pawcare.provider;

import com.pawcare.Reviews.Reviews;
import com.pawcare.providerservice.ProvService;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider{

    //items
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer providerID;

    @Column(nullable = false)
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name="bio")
    private String bio;

    @Column(name = "role")  // Renamed to 'role' instead of 'PROVIDER'
    private String role;

    //relationships
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ProvService>  services = new ArrayList<>();

    public List<ProvService> getServices() {
        return services;
    }

    //constructors
    public Provider(){
    }

    public Provider(String name, Integer providerID, String email, String username, String password,String bio, String role){
        this.name = name;
        this.providerID = providerID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.role = role;

    }

    public Provider(String name, Integer providerID, String email, String username, String password){
        this.name = name;
        this.providerID = providerID;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //gets and sets
    public void setRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Integer getProviderID(){
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail () {
        return  email;
    }
    public void setEmail (String email) {
        this.email = email;
    }

    public String getUsername (){
        return username;
    }
    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword (){
        return password;
    }
    public void setPassword (String password){
        this.password = password;
    }

    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
}


