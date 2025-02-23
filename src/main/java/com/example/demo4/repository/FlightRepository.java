package com.example.demo4.repository;

import com.example.demo4.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAirline(String airline);

}
