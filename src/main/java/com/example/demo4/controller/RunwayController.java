package com.example.demo4.controller;

import com.example.demo4.model.Airport;
import com.example.demo4.model.Runway;
import com.example.demo4.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/runways")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")

public class RunwayController {
    @Autowired
    private RunwayRepository runwayRepository;

    @GetMapping
    public ResponseEntity<List<Runway>> getAllRunways() {
        List<Runway> runways = runwayRepository.findAll();
        return new ResponseEntity<>(runways, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Runway> getRunwayById(@PathVariable String id) {
        Optional<Runway> runway = runwayRepository.findById(id);
        return runway.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Runway> createRunway(@RequestBody Runway runway) {
        Runway savedRunway = runwayRepository.save(runway);
        return new ResponseEntity<>(savedRunway, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Runway> updateRunway(@PathVariable String id, @RequestBody Runway runwayDetails) {
        Optional<Runway> optionalRunway = runwayRepository.findById(id);
        if (optionalRunway.isPresent()) {
            Runway runway = optionalRunway.get();
            runway.setRunwayName(runwayDetails.getRunwayName());
            runway.setRunwayLength(runwayDetails.getRunwayLength());
            runway.setRunwayWidth(runwayDetails.getRunwayWidth());
            runway.setAirportCode(runwayDetails.getAirportCode());
            Runway updatedRunway = runwayRepository.save(runway);
            return new ResponseEntity<>(updatedRunway, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRunway(@PathVariable String id) {
        try {
            runwayRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataIntegrityViolationException e) {
            String errorMessage = "Cannot delete runway because it is associated with a flight";
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/airportCode/{airportCode}")
    public ResponseEntity<List<Runway>> getRunwaysByAirportCode(@PathVariable Airport airportCode) {
        List<Runway> runways = runwayRepository.findByAirportCode(airportCode);
        return new ResponseEntity<>(runways, HttpStatus.OK);
    }

    @GetMapping("/runwayName/{runwayName}")
    public ResponseEntity<List<Runway>> getRunwaysByRunwayName(@PathVariable String runwayName) {
        List<Runway> runways = runwayRepository.findByRunwayName(runwayName);
        return new ResponseEntity<>(runways, HttpStatus.OK);
    }


}







