package com.example.demo4.controller;
import com.example.demo4.model.Flight;
import com.example.demo4.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        List<Flight> flights;
        flights = flightRepository.findAll();
        return flights;
    }
}
