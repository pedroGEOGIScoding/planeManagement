package com.example.planeManagement.repository;

import com.example.planeManagement.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>, JpaSpecificationExecutor<Airport> {
    List<Airport> findByAirportCodeContaining(String airportCodeKeyword);

    List<Airport> findByAirportNameContaining(String airportNameKeyword);
}
