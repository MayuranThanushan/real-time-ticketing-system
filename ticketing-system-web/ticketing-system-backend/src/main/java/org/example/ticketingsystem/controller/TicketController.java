package org.example.ticketingsystem.controller;

import org.example.ticketingsystem.entity.Ticket;
import org.example.ticketingsystem.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a RESTful web service controller
@RequestMapping("/api/tickets")  // Maps HTTP requests to this controller at the "/api/tickets" URL path
public class TicketController {

    private final TicketService ticketService;  // Service for handling ticket-related operations

    // Constructor injection for TicketService
    // This ensures that the TicketService is properly injected into the controller
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Method to create a new ticket.
     *
     * @param name The name of the ticket.
     * @return The created Ticket object.
     */
    @PostMapping  // Maps POST requests to "/api/tickets" to this method
    public Ticket addTicket(@RequestParam String name) {
        return ticketService.addTicket(name);  // Creates a new ticket and returns it
    }

    /**
     * Method to get all tickets.
     *
     * @return A list of all Ticket objects.
     */
    @GetMapping  // Maps GET requests to "/api/tickets" to this method
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();  // Returns a list of all tickets
    }

    /**
     * Method to delete all tickets.
     *
     * @return A message indicating that all tickets have been deleted.
     */
    @DeleteMapping  // Maps DELETE requests to "/api/tickets" to this method
    public String deleteAllTickets() {
        ticketService.deleteAllTickets();  // Deletes all tickets
        return "All tickets deleted successfully.";  // Confirmation message
    }

    /**
     * Method to update a ticket.
     *
     * @param id The ID of the ticket to be updated.
     * @param updatedTicket The updated ticket object.
     * @return The updated Ticket object.
     */
    @PutMapping("/{id}")  // Maps PUT requests to "/api/tickets/{id}" to this method
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        return ticketService.updateTicket(id, String.valueOf(updatedTicket));  // Updates the ticket with the specified ID and returns the updated ticket
    }

    // Getter method to access TicketService
    public TicketService getTicketService() {
        return ticketService;
    }
}
