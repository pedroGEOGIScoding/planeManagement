package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String flightNumber;
    private String airline;
    private int flightDuration;
    private String flightStatus;
    private boolean isFlying;

    @ManyToMany (mappedBy = "flightNumber")
    private List <Airport> originAirport;
    @ManyToMany (mappedBy = "flightNumber")
    private List <Airport> arrivalAirport;


}
