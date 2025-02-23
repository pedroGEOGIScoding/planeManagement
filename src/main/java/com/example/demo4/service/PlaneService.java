package com.example.demo4.service;

import com.example.demo4.model.Flight;
import com.example.demo4.model.Plane;
import com.example.demo4.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    };

    public Optional<Plane> getPlaneById(String id) {
        return planeRepository.findById(id);
    }


}
