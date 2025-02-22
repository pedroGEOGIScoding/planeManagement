package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Airport {

    @Id
    private String airportName;
    private String airportCode;
    private String airportCity;
    private String airportCountry;
    private int numberOfRunways;

    @OneToMany (mappedBy = "airportCode")
    private List<Plane> planes;

    public Airport(String airportName, String airportCode, String airportCity, String airportCountry, int numberOfRunways, List<Plane> planes) {
        this.airportName = airportName;
        this.airportCode = airportCode;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.numberOfRunways = numberOfRunways;
        this.planes = planes;
    }

    public Airport() {

    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public int getNumberOfRunways() {
        return numberOfRunways;
    }

    public void setNumberOfRunways(int numberOfRunways) {
        this.numberOfRunways = numberOfRunways;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "numberOfRunways=" + numberOfRunways +
                ", airportCountry='" + airportCountry + '\'' +
                ", airportCity='" + airportCity + '\'' +
                ", airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                '}';
    }
}
