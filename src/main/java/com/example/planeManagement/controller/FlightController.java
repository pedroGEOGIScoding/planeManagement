package com.example.planeManagement.controller;
import com.example.planeManagement.model.Flight;
import com.example.planeManagement.repository.FlightRepository;
import com.example.planeManagement.repository.FlightSpecification;
import com.example.planeManagement.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public  Page<Flight> flightPageable(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    @GetMapping("page/{pageNo}")
    public Page<Flight> getFlightsPaginated(@PathVariable(value = "pageNo") int pageNo) {
        final int PAGE_SIZE = 5;
        return flightService.findPaginated(pageNo, PAGE_SIZE);
    }

    @GetMapping("/flights/filter")
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
    public ResponseEntity<?> deleteFlight(@PathVariable String id) {
        try {
            flightRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataIntegrityViolationException e) {
            String errorMessage = "Cannot delete flight because it is associated with a flight";
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<List<Flight>> getFlightsByAirport(@PathVariable String id) {
        List<Flight> flights = flightRepository.findByFlightNumber(id);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/airlines/{id}")
    public ResponseEntity<List<Flight>> getFlightsByAirline(@PathVariable String id) {
        List<Flight> flights = flightRepository.findByAirline(id);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}






