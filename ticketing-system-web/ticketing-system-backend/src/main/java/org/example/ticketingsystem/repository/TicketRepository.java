package org.example.ticketingsystem.repository;

import java.util.List;

import org.example.ticketingsystem.entity.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Ticket entity, extending JpaRepository
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // The JpaRepository provides basic CRUD methods like save(), findById(), findAll(), deleteById(), etc.
}
