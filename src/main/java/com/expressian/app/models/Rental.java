package com.expressian.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rental {

    @Id
    @GeneratedValue
    private Long id;
    private Long vehicleId;
    private Long customerId;
    private Date startDate;
    private Date endDate;
    private Float fuelLevel;
    private Float price;

    public Rental() {}

    public Rental(Long vehicleId, Long customerId, Date startDate, Date endDate, Float fuelLevel, Float price) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
