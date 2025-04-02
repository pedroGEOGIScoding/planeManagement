package com.example.planeManagement.repository;

import com.example.planeManagement.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {

    List<Plane> findByAirline(String airline);
    List<Plane> findByModel(String model);
    List<Plane> findByManufacturer(String manufacturer);


}