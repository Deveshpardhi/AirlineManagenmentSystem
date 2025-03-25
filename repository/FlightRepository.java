package com.airline.management.repository;

import com.airline.management.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Additional query methods if needed
}
