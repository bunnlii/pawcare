package com.Pawcare.providerservice;

import com.Pawcare.provider.Provider;
import com.Pawcare.providerservice.ProvService;
import jakarta.persistence.*;


@Entity
@Table(name = "service")
public class ProvService {

    //items
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceID;

    @Column(nullable = false)
    private String serviceType;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String details;
    @Column(nullable = false)
    private String location;

    //relationship
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public Provider getProvider() {
        return provider;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ProvService(){
    }

    public ProvService(int serviceID, String serviceType, double price, String details, String location, Provider provider){
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.price = price;
        this.details = details;
        this.location = location;
        this.provider = provider;
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

    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
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
