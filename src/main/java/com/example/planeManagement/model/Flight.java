package com.example.planeManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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

public class Flight {

    @Id
    @UuidGenerator
    private String id;

    private String flightNumber;
    private String airline;
    private int flightDuration;
    private boolean isFlying;
    private String arrivalAirport;
    private String originAirport;

    @ManyToMany(mappedBy = "flights")
    private List<Airport> airports = new ArrayList<>();

    @JsonIgnore
    @ManyToMany @Cascade(CascadeType.ALL)
    @JoinTable(name = "PLANE_FLIGHT_JOIN_TABLE",
            joinColumns =  { @JoinColumn(name = "FLIGHT_FK") },
            inverseJoinColumns = { @JoinColumn(name = "PLANE_FK") })
    private List<Plane> planes = new ArrayList<>();

}
