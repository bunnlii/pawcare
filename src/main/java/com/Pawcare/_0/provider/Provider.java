package com.Pawcare._0.provider;

import com.Pawcare._0.Reviews.Reviews;
import com.Pawcare._0.Service.Service;
import com.Pawcare._0.Statistics.Statistics;
import jakarta.persistence.*;
import java.util.List;

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
    private String location;
    private String bio;

    //relationships
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Service> services;

    @OneToOne(cascade = CascadeType.ALL)
    private Statistics statistics;

    public Provider(){
    }

    public Provider(String name, int providerID, String email, String username, String password, String location, String bio){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.location = location;
        this.bio = bio;
    }

    public Provider(String name, int providerID, String email, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
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

    private String getPassword (){
        return password;
    }
    private void setPassword (String password){
        this.password = password;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
}


