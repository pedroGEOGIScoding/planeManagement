package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plane {
    @Id
    private String id;
    private String model;
    private String airline;
    private String manufacturer;
    private int capacity;
    private double range;
    private double cruiseSpeed;
    private double currentFlight;
    private boolean isFlying;

    public Plane () {
    }

    public Plane(boolean isFlying, double currentFlight, double cruiseSpeed, double range, int capacity, String manufacturer, String airline, String model, String id) {
        this.isFlying = isFlying;
        this.currentFlight = currentFlight;
        this.cruiseSpeed = cruiseSpeed;
        this.range = range;
        this.capacity = capacity;
        this.manufacturer = manufacturer;
        this.airline = airline;
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(double currentFlight) {
        this.currentFlight = currentFlight;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }
}

