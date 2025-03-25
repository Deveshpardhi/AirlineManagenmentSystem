package com.airline.management.service;

import com.airline.management.entity.Flight;
import com.airline.management.entity.Schedule;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.FlightRepository;
import com.airline.management.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Flight> getAllFlights(String sort) {
        Sort sortOrder = sort.equalsIgnoreCase("asc")
                ? Sort.by("flightNumber").ascending()
                : Sort.by("flightNumber").descending();
        return flightRepository.findAll(sortOrder);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }

    public List<Schedule> getSchedules(Long flightId, String dates) {
        // For simplicity, assume 'dates' is a single date in ISO format (yyyy-MM-dd)
        LocalDate date = LocalDate.parse(dates);
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return scheduleRepository.findByFlightIdAndDepartureTimeBetween(flightId, start, end);
    }
}
