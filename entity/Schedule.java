package com.airline.management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Flight flight;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    // Constructors, getters, setters
}
