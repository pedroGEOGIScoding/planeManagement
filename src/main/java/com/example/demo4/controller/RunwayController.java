package com.example.demo4.controller;

import com.example.demo4.model.Runway;
import com.example.demo4.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunwayController {
    @Autowired
    RunwayRepository runwayRepository;

    @GetMapping("/runways")
    public List<Runway> getAllRunways() {
        return runwayRepository.findAll();
    }
}
