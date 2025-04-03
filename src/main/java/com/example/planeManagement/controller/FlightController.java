package com.example.planeManagement.controller;

import com.example.planeManagement.model.Flight;
import com.example.planeManagement.repository.FlightRepository;
import com.example.planeManagement.repository.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) String originAirport
    ) {
        List<Flight> flights = flightRepository.findAll(FlightSpecification.filterByParams(flightNumber, arrivalAirport, originAirport));
        return ResponseEntity.ok(flights);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable String id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightRepository.save(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String id, @RequestBody Flight flightDetails) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            Flight existingflight = optionalFlight.get();
            existingflight.setFlightNumber(flightDetails.getFlightNumber());
            existingflight.setAirline(flightDetails.getAirline());
            existingflight.setArrivalAirport(flightDetails.getArrivalAirport());
            existingflight.setOriginAirport(flightDetails.getOriginAirport());

            Flight updatedFlight = flightRepository.save(existingflight);
            return ResponseEntity.ok(updatedFlight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<List<Flight>> getFlightsByAirport(@PathVariable String id) {
        List<Flight> flights = flightRepository.findByFlightNumber(id);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/airlines/{id}")
    public ResponseEntity<List<Flight>> getFlightsByAirline(@PathVariable String id) {
        List<Flight> flights = flightRepository.findByAirline(id);
        return ResponseEntity.ok(flights);
    }
}






