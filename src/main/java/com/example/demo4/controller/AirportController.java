package com.example.demo4.controller;
import com.example.demo4.model.Airport;
import com.example.demo4.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {
    @Autowired
    AirportRepository airportRepository;

    @GetMapping("/airports")
    public List<Airport> getAllAirports(){
        List<Airport> airports = airportRepository.findAll();
        return airportRepository.findAll();
    }



}
