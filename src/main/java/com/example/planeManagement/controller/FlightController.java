package com.example.planeManagement.controller;

import com.example.planeManagement.model.Flight;
import com.example.planeManagement.repository.FlightRepository;
import com.example.planeManagement.repository.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public ResponseEntity<List<Flight>> filterFlights(
            @RequestParam(required = false) String flightNumber,
            @RequestParam(required = false) String airline,
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) String originAirport
    ) {
        Specification<Flight> flightSpecification = FlightSpecification.filterByParams(flightNumber, airline, arrivalAirport, originAirport);
        List<Flight> flights = flightRepository.findAll(flightSpecification);
        return ResponseEntity.ok(flights);
        }
}






