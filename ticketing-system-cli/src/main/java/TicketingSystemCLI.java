import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Command Line Interface for the Ticketing System.
 * Handles configuration, ticket pool initialization, and vendor/customer operations.
 */
public class TicketingSystemCLI {

    /**
     * The configuration settings for the ticketing system.
     */
    private static Configuration configuration;

    /**
     * The ticket pool for storing tickets.
     */
    private static TicketPool ticketPool;

    /**
     * Main method to run the Ticketing System CLI.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.println("Welcome to the Ticketing System CLI");

        // Load configuration
        if (new File("config.json").exists()) {
            try (Reader reader = new FileReader("config.json")) {
                Type configType = new TypeToken<Configuration>() {}.getType();
                configuration = gson.fromJson(reader, configType);
                System.out.println("Configuration loaded from file.");
            } catch (IOException e) {
                System.err.println("Failed to load configuration. Please re-enter the details.");
                configuration = new Configuration();
            }
        } else {
            configuration = new Configuration();
        }

        // Prompt user for configuration
        System.out.print("Enter Total Number of Tickets: ");
        configuration.setTotalTickets(validatePositiveInt(scanner));

        System.out.print("Enter Ticket Release Rate: ");
        configuration.setTicketReleaseRate(validatePositiveInt(scanner));

        System.out.print("Enter Customer Retrieval Rate: ");
        configuration.setCustomerRetrievalRate(validatePositiveInt(scanner));

        System.out.print("Enter Maximum Ticket Capacity: ");
        configuration.setMaxTicketCapacity(validatePositiveInt(scanner));

        // Save configuration
        try (Writer writer = new FileWriter("config.json")) {
            gson.toJson(configuration, writer);
            System.out.println("Configuration saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save configuration.");
        }

        // Initialize Ticket Pool
        ticketPool = new TicketPool(configuration.getMaxTicketCapacity());
        ticketPool.addTickets(configuration.getTotalTickets());
        System.out.println("Ticket pool initialized with " + configuration.getTotalTickets() + " tickets.");

        // Start vendor and customer threads
        System.out.println("Starting the system...");
        new Thread(new VendorRunnable(ticketPool, configuration)).start();
        new Thread(new CustomerRunnable(ticketPool, configuration)).start();

        System.out.println("System started. Press ENTER to stop...");
        scanner.nextLine();

        // Stop the system
        System.out.println("Stopping the system...");
        System.exit(0);
    }

    /**
     * Validates that the input is a positive integer.
     * @param scanner the Scanner object to read input.
     * @return a positive integer entered by the user.
     */
    private static int validatePositiveInt(Scanner scanner) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value > 0) break;
                System.out.print("Please enter a positive number: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a positive number: ");
            }
        }
        return value;
    }
}
