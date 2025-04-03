package com.example.planeManagement.controller;
import com.example.planeManagement.model.Airport;
import com.example.planeManagement.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airports")
@CrossOrigin(origins = "http://localhost:5173")

public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String id) {
        Optional<Airport> airport = airportRepository.findById(id);
        return airport.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport savedAirport  = airportRepository.save(airport);
        return new ResponseEntity<>(savedAirport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    //airportDetails es una variable de referencia que se crea dentro de @RequestBody
    public ResponseEntity<Airport> updateAirport(@PathVariable String id, @RequestBody Airport airportDetails) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        if (optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airport.setAirportName(airportDetails.getAirportName());
            airport.setAirportCode(airportDetails.getAirportCode());
            airport.setAirportCity(airportDetails.getAirportCity());
            airport.setAirportCountry(airportDetails.getAirportCountry());
            airport.setAirportLatitude(airportDetails.getAirportLatitude());
            airport.setAirportLongitude(airportDetails.getAirportLongitude());
            airport.setAirportElevation(airportDetails.getAirportElevation());
            Airport updatedAirport = airportRepository.save(airport);
            return new ResponseEntity<>(updatedAirport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable String id) {
       try {
           airportRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       } catch (DataIntegrityViolationException e) {
           String errorMessage = "Cannot delete airport because it is associated with a flight";
           return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/airportCode/{keyword}")
    public ResponseEntity<List<Airport>> getAirportByAirportCodeKeyword(@PathVariable String keyword) {
    List<Airport> airports = airportRepository.findByAirportCodeContaining(keyword);
    return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/airportName/{keyword}")
    public ResponseEntity<List<Airport>> getAirportByAirportNameKeyword(@PathVariable String keyword) {
    List<Airport> airports = airportRepository.findByAirportNameContaining(keyword);
    return new ResponseEntity<>(airports, HttpStatus.OK);
    }
    }


