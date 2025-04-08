package com.example.planeManagement.service;

import com.example.planeManagement.model.Airport;
import com.example.planeManagement.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

	@Autowired
	private AirportRepository airportRepository;

	public Page<Airport> findPaginated(int pageNo, int pageSize) {
		if (pageNo < 1) throw new IllegalArgumentException("Invalid page number: " + pageNo);
		// Cap page size at 100 to prevent excessive data retrieval
		Pageable pageable = PageRequest.of(
				pageNo - 1,
				Math.max(1, Math.min(pageSize, 100)));

		return airportRepository.findAll(pageable);
	}
}
