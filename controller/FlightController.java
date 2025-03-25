package com.airline.management.controller;

import com.airline.management.entity.Flight;
import com.airline.management.entity.Schedule;
import com.airline.management.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // GET /flights?sort=asc
    @GetMapping
    public List<Flight> getAllFlights(@RequestParam(name = "sort", defaultValue = "asc") String sort) {
        return flightService.getAllFlights(sort);
    }

    // GET /flights/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    // GET /flights/{id}/schedules?dates=yyyy-MM-dd
    @GetMapping("/{id}/schedules")
    public List<Schedule> getSchedules(@PathVariable Long id, @RequestParam(name = "dates") String dates) {
        return flightService.getSchedules(id, dates);
    }
}
