package com.example.demo4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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
    private String flightStatus;
    private boolean isFlying;


    @OneToOne(mappedBy = "flight")
    private Plane plane;

}
