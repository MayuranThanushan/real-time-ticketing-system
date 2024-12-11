/**
 * Represents a pool of tickets with a maximum capacity.
 * Handles synchronized operations to safely add and remove tickets in a concurrent environment.
 */
class TicketPool {
    /**
     * The current number of available tickets in the pool.
     */
    private int availableTickets;

    /**
     * The maximum capacity of tickets that the pool can hold.
     */
    private final int maxCapacity;

    /**
     * Constructs a new TicketPool with the specified maximum capacity.
     * Initially, the pool has zero available tickets.
     *
     * @param maxCapacity the maximum number of tickets the pool can hold.
     */
    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.availableTickets = 0;
    }

    /**
     * Gets the current number of available tickets in the pool.
     * This method is synchronized to ensure thread-safe access to the ticket count.
     *
     * @return the number of available tickets.
     */
    public synchronized int getAvailableTickets() {
        return availableTickets;
    }

    /**
     * Adds the specified number of tickets to the pool.
     * If adding the tickets exceeds the maximum capacity, the pool is filled to its maximum capacity.
     * This method is synchronized to ensure thread-safe updates to the ticket count.
     *
     * @param ticketsToAdd the number of tickets to add to the pool.
     */
    public synchronized void addTickets(int ticketsToAdd) {
        if (availableTickets + ticketsToAdd > maxCapacity) {
            // Cap the available tickets at the maximum capacity
            availableTickets = maxCapacity;
        } else {
            // Add the specified number of tickets to the pool
            availableTickets += ticketsToAdd;
        }
    }

    /**
     * Removes one ticket from the pool.
     * If no tickets are available, an exception is thrown.
     * This method is synchronized to ensure thread-safe updates to the ticket count.
     *
     * @throws IllegalStateException if there are no tickets available to remove.
     */
    public synchronized void removeTicket() {
        if (availableTickets > 0) {
            // Decrease the available ticket count by one
            availableTickets--;
        } else {
            // Throw an exception if there are no tickets to remove
            throw new IllegalStateException("No tickets available to remove.");
        }
    }
}
