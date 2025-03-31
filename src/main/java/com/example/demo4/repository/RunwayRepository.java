package com.example.demo4.repository;

import com.example.demo4.model.Airport;
import com.example.demo4.model.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, String> {
    List<Runway> findByAirportCode(Airport airportCode);
}
