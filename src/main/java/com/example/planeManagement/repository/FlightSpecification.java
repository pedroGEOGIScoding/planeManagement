package com.example.planeManagement.repository;

import com.example.planeManagement.model.Airport;
import com.example.planeManagement.model.Flight;
import com.example.planeManagement.model.Plane;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class FlightSpecification {

    public static Specification<Flight> filterByParams(
            String flightNumber,
            String airline,
            String arrivalAirport,
            String originAirport
    ) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            Join<Flight, Plane> planeJoin = root.join("plane", JoinType.INNER);
            Join<Flight, Airport> arrivalAirportJoin = root.join("arrivalAirport", JoinType.INNER);
            Join<Flight, Airport> originAirportJoin = root.join("originAirport", JoinType.INNER);

            if(flightNumber != null && !flightNumber.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(planeJoin.get("flightNumber"), "%" + flightNumber + "%"));}

            if(arrivalAirport != null && !arrivalAirport.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(arrivalAirportJoin.get("airportName"), "%" + arrivalAirport + "%"));}

            if(originAirport != null && !originAirport.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(originAirportJoin.get("airportName"), "%" + originAirport + "%"));}

            return predicate;

        };
    }
}
