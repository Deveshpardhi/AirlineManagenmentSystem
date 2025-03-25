package com.airline.management.controller;

import com.airline.management.entity.Ticket;
import com.airline.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // POST /tickets/ - create a ticket (book ticket)
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    // GET /tickets/{id} - get ticket details
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    // DELETE /tickets/{id} - cancel ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.noContent().build();
    }
}
