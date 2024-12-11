import React, { useState } from 'react';
import axios from 'axios';

/**
 * ConfigurationForm component allows users to configure system parameters
 * such as total tickets, ticket release rate, customer retrieval rate,
 * and maximum ticket capacity. It submits the configuration data to the backend API.
 *
 * @component
 */
const ConfigurationForm = () => {
    // State variables to hold form input values
    const [totalTickets, setTotalTickets] = useState(''); // Total number of tickets
    const [ticketReleaseRate, setTicketReleaseRate] = useState(''); // Rate at which tickets are released
    const [customerRetrievalRate, setCustomerRetrievalRate] = useState(''); // Rate at which customers retrieve tickets
    const [maxTicketCapacity, setMaxTicketCapacity] = useState(''); // Maximum ticket capacity of the system

    /**
     * Handles form submission by sending configuration data to the backend API.
     * 
     * @param {Object} e - The event object from the form submission.
     * @async
     */
    const handleSubmit = async (e) => {
        e.preventDefault(); // Prevent default form submission behavior

        // Create configuration object
        const config = {
            totalTickets,
            ticketReleaseRate,
            customerRetrievalRate,
            maxTicketCapacity,
        };

        try {
            // Send configuration data to the API
            const response = await axios.post('http://localhost:8080/api/config', config);
            console.log(response.data); // Log the API response
            alert('Configuration saved successfully'); // Inform the user of success
        } catch (error) {
            console.error('Error saving configuration:', error); // Log the error
            alert('Failed to save configuration'); // Inform the user of failure
        }
    };

    return (
        <div className="ConfigurationForm">
            <h3>Configure System Parameters</h3>
            <form onSubmit={handleSubmit}>
                <div className="FormInput">
                    <label>Total Tickets:</label>
                    <input
                        type="number"
                        value={totalTickets}
                        onChange={(e) => setTotalTickets(e.target.value)}
                        required
                    />
                </div>
                <div className="FormInput">
                    <label>Ticket Release Rate:</label>
                    <input
                        type="number"
                        value={ticketReleaseRate}
                        onChange={(e) => setTicketReleaseRate(e.target.value)}
                        required
                    />
                </div>
                <div className="FormInput">
                    <label>Customer Retrieval Rate:</label>
                    <input
                        type="number"
                        value={customerRetrievalRate}
                        onChange={(e) => setCustomerRetrievalRate(e.target.value)}
                        required
                    />
                </div>
                <div className="FormInput">
                    <label>Max Ticket Capacity:</label>
                    <input
                        type="number"
                        value={maxTicketCapacity}
                        onChange={(e) => setMaxTicketCapacity(e.target.value)}
                        required
                    />
                </div>
                <button className="SaveConfig" type="submit">Save Configuration</button>
            </form>
        </div>
    );
};

export default ConfigurationForm;
