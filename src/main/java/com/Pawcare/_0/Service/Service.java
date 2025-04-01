package com.Pawcare._0.Service;

import com.Pawcare._0.provider.Provider;
import jakarta.persistence.*;

public class Service {

    //items
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceID;

    @Column(nullable = false)
    private String serviceType;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String details;
    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "providerID")
    private Provider provider;


    public Service(){
    }

    public Service(int serviceID, String serviceType, int price, String details, String location){
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.price = price;
        this.details = details;
        this.location = location;
    }

    public int getServiceID (){
        return serviceID;
    }
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceType(){
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails(){
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
