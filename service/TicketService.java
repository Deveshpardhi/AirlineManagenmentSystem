package com.airline.management.service;

import com.airline.management.entity.Flight;
import com.airline.management.entity.Ticket;
import com.airline.management.exception.DuplicateTicketException;
import com.airline.management.exception.ResourceNotFoundException;
import com.airline.management.repository.FlightRepository;
import com.airline.management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Ticket createTicket(Ticket ticket) {
        // Validate flight exists
        Flight flight = flightRepository.findById(ticket.getFlight().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
        
        // Check for duplicate booking for the same flight and passenger email
        if (ticketRepository.existsByFlightIdAndPassengerEmail(flight.getId(), ticket.getPassengerEmail())) {
            throw new DuplicateTicketException("Ticket already booked for this passenger on flight: " + flight.getFlightNumber());
        }
        ticket.setBookingDate(LocalDate.now());
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
    }

    public void cancelTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}
