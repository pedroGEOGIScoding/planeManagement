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

public class Runway {

    @Id
    @UuidGenerator

    private String id;
    private String runwayName;
    private int runwayLength;
    private int runwayWidth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_fk")
    private Airport airportCode;
}
