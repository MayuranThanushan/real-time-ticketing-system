import java.time.LocalDateTime;

/**
 * Runnable implementation for simulating vendor behavior in the ticketing system.
 * Vendors release tickets to the shared TicketPool at a specified rate until the total tickets are released.
 */
class VendorRunnable implements Runnable {

    /**
     * The shared ticket pool to which tickets are added.
     */
    private final TicketPool ticketPool;

    /**
     * The configuration object defining system parameters like ticket release rate and total tickets.
     */
    private final Configuration configuration;

    /**
     * Tracks the total number of tickets released by the vendor.
     */
    private int ticketsReleased = 0;

    /**
     * Constructs a new VendorRunnable.
     * @param ticketPool the shared ticket pool instance.
     * @param configuration the configuration object containing system settings.
     */
    public VendorRunnable(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.configuration = configuration;
    }

    /**
     * Executes the vendor logic:
     * - Continuously adds tickets to the ticket pool based on the release rate.
     * - Stops when the total number of tickets to be released is reached.
     */
    @Override
    public void run() {
        while (ticketsReleased < configuration.getTotalTickets()) {
            synchronized (ticketPool) {
                // Determine how many tickets to release in this cycle
                int ticketsToAdd = configuration.getTicketReleaseRate();
                int remainingTickets = configuration.getTotalTickets() - ticketsReleased;

                // Ensure not to exceed the remaining tickets
                if (ticketsToAdd > remainingTickets) {
                    ticketsToAdd = remainingTickets;
                }

                // Add tickets to the pool and update the count of tickets released
                ticketPool.addTickets(ticketsToAdd);
                ticketsReleased += ticketsToAdd;

                // Log the ticket release
                System.out.println(LocalDateTime.now() + " - Vendor released " + ticketsToAdd + " tickets.");
            }

            try {
                // Simulate delay between ticket release cycles
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Restore interrupted status and exit gracefully
                Thread.currentThread().interrupt();
            }
        }
    }
}
