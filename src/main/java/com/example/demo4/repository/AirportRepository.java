package com.example.demo4.repository;

import com.example.demo4.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

    List<Airport> findByAirportCity(String airportCity);
    List<Airport> findByAirportCountry(String airportCountry);
    List<Airport> findByAirportName(String airportName);


}
