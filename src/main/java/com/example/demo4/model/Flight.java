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
    private Long id;

    @OneToOne(mappedBy = "flight")
    public Plane plane;

    private String flightNumber;
    private String airline;
    private int flightDuration;
    private String flightStatus;
    private boolean isFlying;

}
