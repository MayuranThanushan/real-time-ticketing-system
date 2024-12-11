import java.time.LocalDateTime;

/**
 * Runnable implementation for simulating customer behavior in the ticketing system.
 * Customers attempt to retrieve tickets from the shared TicketPool.
 */
class CustomerRunnable implements Runnable {

    /**
     * The shared ticket pool from which tickets are retrieved.
     */
    private final TicketPool ticketPool;

    /**
     * The configuration object defining system parameters like customer retrieval rate.
     */
    private final Configuration configuration;

    /**
     * Constructs a new CustomerRunnable.
     * @param ticketPool the shared ticket pool instance.
     * @param configuration the configuration object containing system settings.
     */
    public CustomerRunnable(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.configuration = configuration;
    }

    /**
     * Executes the customer logic:
     * - Continuously attempts to retrieve tickets from the ticket pool.
     * - Stops when tickets are unavailable.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (ticketPool) {
                if (ticketPool.getAvailableTickets() > 0) {
                    // Retrieve a ticket from the pool
                    ticketPool.removeTicket();
                    System.out.println(LocalDateTime.now() + " - Customer purchased a ticket.");
                } else {
                    // Exit when no tickets are left
                    System.out.println(LocalDateTime.now() + " - No tickets available. Stopping customer thread.");
                    break;
                }
            }

            try {
                // Simulate the delay between ticket purchases based on the configured retrieval rate
                Thread.sleep(1000 / configuration.getCustomerRetrievalRate());
            } catch (InterruptedException e) {
                // Restore interrupted status
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
