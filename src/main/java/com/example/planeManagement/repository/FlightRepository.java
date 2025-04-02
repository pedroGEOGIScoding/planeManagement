package com.example.planeManagement.repository;

import com.example.planeManagement.model.Flight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    List<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAirline(String airline);

    List<Flight> findAll(Specification<Flight> flightSpecification);
}
