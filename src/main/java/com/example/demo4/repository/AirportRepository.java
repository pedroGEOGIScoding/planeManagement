package com.example.demo4.repository;

import com.example.demo4.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    List<Airport> findByAirportCodeContaining(String airportCodeKeyword);

    List<Airport> findByAirportNameContaining(String airportNameKeyword);
}
