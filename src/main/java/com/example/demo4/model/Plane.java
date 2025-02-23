package com.example.demo4.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Plane {
    @Id
    @UuidGenerator
    private String id;

    private String model;
    private String airline;
    private String manufacturer;
    private int capacity;
    private double range;
    private double cruiseSpeed;
    private boolean isFlying;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Flight flight;



}

