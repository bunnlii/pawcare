package com.pawcare.Provider;

import com.pawcare.Reviews.Reviews;
import com.pawcare.service.Service;
import com.pawcare.Statistics.Statistics;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider{

    //items
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int providerID;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String bio;

    //relationships
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Service> services;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private Statistics statistics;

    //constructors
    public Provider(){
    }

    public Provider(String name, int providerID, String email, String username, String password,String bio){
        this.name = name;
        this.providerID = providerID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }

    public Provider(String name, int providerID, String email, String username, String password){
        this.name = name;
        this.providerID = providerID;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //gets and sets
    public int getProviderID(){
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


