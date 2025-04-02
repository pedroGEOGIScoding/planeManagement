package com.example.planeManagement.controller;
import com.example.planeManagement.model.Plane;
import com.example.planeManagement.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planes")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")

public class PlaneController {
    @Autowired
    PlaneRepository planeRepository;

    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes() {
    List<Plane> planes = planeRepository.findAll();
    return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable String id) {
    Optional<Plane> plane = planeRepository.findById(id);
    return plane.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane){
        Plane savedPlane = planeRepository.save(plane);
        return new ResponseEntity<>(savedPlane, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable String id, @RequestBody Plane planeDetails) {
        Optional<Plane> optionalPlane = planeRepository.findById(id);
        if (optionalPlane.isPresent()) {
            Plane plane = optionalPlane.get();
            plane.setModel(planeDetails.getModel());
            plane.setAirline(planeDetails.getAirline());
            plane.setManufacturer(planeDetails.getManufacturer());
            plane.setCapacity(planeDetails.getCapacity());
            plane.setRange(planeDetails.getRange());
            plane.setCruiseSpeed(planeDetails.getCruiseSpeed());
            plane.setIsFlying(planeDetails.getIsFlying());
            Plane updatedPlane = planeRepository.save(plane);
            return new ResponseEntity<>(updatedPlane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlane(@PathVariable String id) {
        try {
            planeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataIntegrityViolationException e) {
            String errorMessage = "Cannot delete plane because it is associated with a flight";
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Plane>> getPlanesByModel(@PathVariable String model) {
        List<Plane> planes = planeRepository.findByModel(model);
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @GetMapping("/airline/{airline}")
    public ResponseEntity<List<Plane>> getPlanesByAirline(@PathVariable String airline) {
        List<Plane> planes = planeRepository.findByAirline(airline);
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    public ResponseEntity<List<Plane>> getPlanesByManufacturer(@PathVariable String manufacturer) {
        List<Plane> planes = planeRepository.findByManufacturer(manufacturer);
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }
}
