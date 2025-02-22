package com.example.demo4.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String airline;
    private String manufacturer;
    private int capacity;
    private double range;
    private double cruiseSpeed;
    private boolean isFlying;
    private String flightNumber;


    @OneToOne(mappedBy = "plane2", cascade = CascadeType.ALL)
    private Flight flight;

    //CONSTRUCTORS
    public Plane () {
    }

    public Plane(boolean isFlying, double cruiseSpeed, double range, int capacity, String manufacturer, String airline, String model, String id) {
        this.isFlying = isFlying;
        this.cruiseSpeed = cruiseSpeed;
        this.range = range;
        this.capacity = capacity;
        this.manufacturer = manufacturer;
        this.airline = airline;
        this.model = model;
    }

    //GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
                ", isFlying=" + isFlying +
                '}';
    }

    @OneToOne(mappedBy = "plane", optional = false)
    private Flight flight2;

    public Flight getFlight2() {
        return flight2;
    }

    public void setFlight2(Flight flight2) {
        this.flight2 = flight2;
    }
}

