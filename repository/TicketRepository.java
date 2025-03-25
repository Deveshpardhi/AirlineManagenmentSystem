package com.airline.management.repository;

import com.airline.management.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    boolean existsByFlightIdAndPassengerEmail(Long flightId, String passengerEmail);
}
