package com.example.demo4.model;

import jakarta.persistence.*;

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
    private boolean isFlying;

    @OneToOne (mappedBy = "flightNumber", cascade = CascadeType.ALL)
    private Flight flightNumber;

    public Plane () {
    }

    public Plane(boolean isFlying, Flight flightNumber, double cruiseSpeed, double range, int capacity, String manufacturer, String airline, String model, String id) {
        this.isFlying = isFlying;
        this.flightNumber = flightNumber;
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

    public Flight getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Flight flightNumber) {
        this.flightNumber = flightNumber;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", airline='" + airline + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                ", range=" + range +
                ", cruiseSpeed=" + cruiseSpeed +
                ", currentFlightNumber=" + flightNumber +
                ", isFlying=" + isFlying +
                '}';
    }
}

