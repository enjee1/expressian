package com.expressian.app.models;

import javax.persistence.*;

@Entity
public class
Rental {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private String startDate;
    private String endDate;
    private Float fuelLevel;
    private Float price;

    public Rental() {}

    public Rental(String startDate, String endDate, Float fuelLevel, Float price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.fuelLevel = fuelLevel;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Float getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Float fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
