package com.example.planeManagement.repository;

import com.example.planeManagement.model.Airport;
import com.example.planeManagement.model.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, String> {
    List<Runway> findByAirportCode(Airport airportCode);

    List<Runway> findByRunwayName(String runwayName);
}
