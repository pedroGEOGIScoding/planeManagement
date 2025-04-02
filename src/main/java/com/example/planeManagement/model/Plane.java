package com.example.planeManagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

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

    @ManyToMany(mappedBy = "planes", cascade = {PERSIST, MERGE, DETACH}, fetch = FetchType.EAGER)
    private List<Flight> flights = new ArrayList<>();


    public Object getIsFlying() {
        return null;
    }

    public void setIsFlying(Object isFlying) {
    }
}

