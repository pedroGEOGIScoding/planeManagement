package com.example.demo4.repository;

import com.example.demo4.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {


}
