// src/components/TicketPoolStatus.js
import React, { useEffect, useState } from "react";
import { getStatus } from "../services/api"; // Ensure getStatus is implemented in api.js

/**
 * TicketPoolStatus component fetches and displays the current status of the ticket pool.
 * It shows the number of available tickets and whether the system is running.
 * The status is updated every second by polling the backend.
 *
 * @component
 */
const TicketPoolStatus = () => {
    // State variable to track available tickets
    const [availableTickets, setAvailableTickets] = useState(0);

    // State variable to track if the system is running or not
    const [systemRunning, setSystemRunning] = useState(false);

    /**
     * Fetches the current status of the ticket pool from the backend.
     * Updates the available tickets and system running status based on the response.
     *
     * @async
     */
    const fetchStatus = async () => {
        try {
            const status = await getStatus(); // Fetch status from /api/status
            setAvailableTickets(status.availableTickets); // Update available tickets
            setSystemRunning(status.running); // Update system running status
        } catch (error) {
            console.error("Error fetching status:", error); // Log any errors
        }
    };

    // useEffect hook to fetch status initially and set up polling every second
    useEffect(() => {
        const interval = setInterval(fetchStatus, 1000); // Poll the status every second
        return () => clearInterval(interval); // Cleanup the interval when the component unmounts
    }, []);

    return (
        <div>
            <h3>Ticket Pool Status</h3>
            <p>Available Tickets: {availableTickets}</p> {/* Display available tickets */}
            <p>System Running: {systemRunning ? "Yes" : "No"}</p> {/* Display system running status */}
        </div>
    );
};

export default TicketPoolStatus;
