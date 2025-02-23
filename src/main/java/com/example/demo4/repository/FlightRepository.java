package com.example.demo4.repository;

import com.example.demo4.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FlightRepository extends JpaRepository<Flight, String> {
}