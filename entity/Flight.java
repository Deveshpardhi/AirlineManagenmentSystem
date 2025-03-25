package com.airline.management.entity;

import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String source;
    private String destination;

    // Constructors, getters, setters
}
