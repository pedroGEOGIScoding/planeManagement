package com.example.planeManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Airport {

    @Id
    @UuidGenerator
    private String id;

    private String airportName;
    private String airportCode;
    private String airportCity;
    private String airportCountry;
    private float airportLatitude;
    private float airportLongitude;
    private int airportElevation;



    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AIRPORT_FLIGHT_JOIN_TABLE",
            joinColumns =  { @JoinColumn(name = "AIRPORT_FK") },
            inverseJoinColumns = { @JoinColumn(name = "FLIGHT_FK") })
    private List<Flight> flights = new ArrayList<>();
}
