package com.pawcare.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "appointment_date")
    private String appointmentDate;

    public Booking() {
    }

    public Booking(int id, String customerName, String petName, String serviceType, String appointmentDate) {
        this.id = id;
        this.customerName = customerName;
        this.petName = petName;
        this.serviceType = serviceType;
        this.appointmentDate = appointmentDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

}
