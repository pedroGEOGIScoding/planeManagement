package com.example.demo4.model;

import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="plane_id", referencedColumnName = "id")
    public Plane plane;

    private String flightNumber;
    private String airline;
    private int flightDuration;
    private String flightStatus;
    private boolean isFlying;


    //CONSTRUCTORS
    public Flight() {
    }

    public Flight(String flightNumber, String airline, int flightDuration, String flightStatus, boolean isFlying) {
        this.airline = airline;
        this.flightDuration = flightDuration;
        this.flightStatus = flightStatus;
        this.isFlying = isFlying;
    }

    //GETTERS & SETTERS

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

    @OneToOne(optional = false)
    private Plane plane2;

    public Plane getPlane2() {
        return plane2;
    }

    public void setPlane2(Plane plane2) {
        this.plane2 = plane2;
    }
}
