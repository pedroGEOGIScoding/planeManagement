package com.example.demo4.repository;

import com.example.demo4.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {

    List<Plane> findByAirline(String airline);
    List<Plane> findByModel(String model);

}