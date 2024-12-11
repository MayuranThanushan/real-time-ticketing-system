package org.example.ticketingsystem.service;

import org.example.ticketingsystem.entity.Ticket;
import org.example.ticketingsystem.repository.TicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    // Constructor that injects the TicketRepository dependency
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Method to add a new ticket
    public Ticket addTicket(String name) {
        Ticket ticket = new Ticket();  // Create a new Ticket object
        ticket.setName(name);  // Set the name of the ticket
        ticket.setCreatedAt(LocalDateTime.now());  // Set the creation timestamp of the ticket
        return ticketRepository.save(ticket);  // Save the new ticket to the repository and return it
    }

    // Method to retrieve all tickets from the database (non-paginated)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();  // Fetch and return all tickets from the database
    }

    // Method to retrieve all tickets with pagination
    public Page<Ticket> getAllTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);  // Fetch and return paginated tickets from the database
    }

    // Method to delete all tickets from the database
    public void deleteAllTickets() {
        ticketRepository.deleteAll();  // Delete all tickets from the repository (database)
    }

    // Method to update an existing ticket's name
    public Ticket updateTicket(Long id, String name) {
        // Retrieve the ticket by ID, if not found, throw an exception
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));  // Ticket not found exception
        ticket.setName(name);  // Set the new name for the ticket
        return ticketRepository.save(ticket);  // Save the updated ticket and return it
    }
}
