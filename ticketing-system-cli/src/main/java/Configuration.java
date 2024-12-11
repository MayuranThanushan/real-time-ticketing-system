/**
 * Represents the configuration settings for the ticketing system.
 * Stores various parameters such as total tickets, ticket release rate, 
 * customer retrieval rate, and maximum ticket capacity.
 */
class Configuration {

    /**
     * The total number of tickets to be handled by the system.
     */
    private int totalTickets;

    /**
     * The rate at which tickets are released to the pool by the vendor.
     * Represented as the number of tickets added per interval.
     */
    private int ticketReleaseRate;

    /**
     * The rate at which customers retrieve tickets from the pool.
     * Represented as the number of tickets customers attempt to purchase per interval.
     */
    private int customerRetrievalRate;

    /**
     * The maximum number of tickets that the pool can hold at any time.
     */
    private int maxTicketCapacity;

    /**
     * Gets the total number of tickets configured for the system.
     *
     * @return the total number of tickets.
     */
    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * Sets the total number of tickets for the system.
     *
     * @param totalTickets the total number of tickets.
     */
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    /**
     * Gets the rate at which tickets are released by the vendor.
     *
     * @return the ticket release rate.
     */
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    /**
     * Sets the rate at which tickets are released by the vendor.
     *
     * @param ticketReleaseRate the ticket release rate.
     */
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    /**
     * Gets the rate at which customers retrieve tickets.
     *
     * @return the customer retrieval rate.
     */
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    /**
     * Sets the rate at which customers retrieve tickets.
     *
     * @param customerRetrievalRate the customer retrieval rate.
     */
    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    /**
     * Gets the maximum ticket capacity of the pool.
     *
     * @return the maximum ticket capacity.
     */
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    /**
     * Sets the maximum ticket capacity of the pool.
     *
     * @param maxTicketCapacity the maximum ticket capacity.
     */
    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}
