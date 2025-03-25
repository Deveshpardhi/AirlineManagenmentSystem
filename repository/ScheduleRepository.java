package com.airline.management.repository;

import com.airline.management.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByFlightIdAndDepartureTimeBetween(Long flightId, LocalDateTime start, LocalDateTime end);
}
