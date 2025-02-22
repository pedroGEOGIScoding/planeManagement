package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jdk.jfr.DataAmount;

import java.util.List;

@Entity
@DataAmount
public class Flight {

    @Id
    private String flightNumber;
    private String airline;
    private int flightDuration;
    private String flightStatus;
    private boolean isFlying;

    @ManyToMany (mappedBy = "flightNumber")
    private List <Airport> originAirport;
    @ManyToMany (mappedBy = "flightNumber")
    private List <Airport> arrivalAirport;

    public Flight() {
    }

    public Flight(String flightNumber, String airline, int flightDuration, String flightStatus, boolean isFlying) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.flightDuration = flightDuration;
        this.flightStatus = flightStatus;
        this.isFlying = isFlying;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public List<Airport> getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(List<Airport> originAirport) {
        this.originAirport = originAirport;
    }

    public List<Airport> getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(List<Airport> arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "isFlying=" + isFlying +
                ", flightStatus='" + flightStatus + '\'' +
                ", flightDuration=" + flightDuration +
                ", airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}
