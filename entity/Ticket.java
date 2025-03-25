package com.airline.management.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @NotBlank(message = "Passenger email is required")
    @Email(message = "Provide a valid email address")
    private String passengerEmail;

    @ManyToOne
    private Flight flight;

    private LocalDate bookingDate;

    // Constructors, getters, setters
}
