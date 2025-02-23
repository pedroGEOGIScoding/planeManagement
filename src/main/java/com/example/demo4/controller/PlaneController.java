package com.example.demo4.controller;
import com.example.demo4.model.Plane;
import com.example.demo4.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/planes")
public class PlaneController {
    @Autowired
    public PlaneRepository planeRepository;

    @GetMapping("/planes")
    public List<Plane> getAllPlanes() {
        List<Plane> planes;
        planes = planeRepository.findAll();
        return planes;
    }
}
