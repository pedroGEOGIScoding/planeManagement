package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;


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
    private int numberOfRunways;
    @ManyToMany //Esta JPA relation me genera la tabla AIRPORT_PLANES with the foreign keys
    private ArrayList<Plane> planes;

}
