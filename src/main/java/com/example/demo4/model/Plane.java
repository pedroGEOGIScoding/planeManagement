package com.example.demo4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String model;
    private String airline;
    private String manufacturer;
    private int capacity;
    private double range;
    private double cruiseSpeed;
    private boolean isFlying;
    private String flightNumber;

    @OneToOne
    @JoinColumn
    public Flight flight;


}

