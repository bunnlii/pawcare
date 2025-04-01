package com.Pawcare._0.Service;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String serviceID;

    public String serviceType;

    public int price;

    public String details;

    public String note;


}
