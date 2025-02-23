package com.example.demo4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String flightNumber;
    private String airline;
    private int flightDuration;
    private String flightStatus;
    private boolean isFlying;

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
    public Plane plane;



}
