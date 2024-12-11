import React from 'react';
import ConfigurationForm from './components/ConfigurationForm'; // Importing the ConfigurationForm component
import LogsTable from './components/LogsTable'; // Importing the LogsTable component
import SystemControl from './components/SystemControl'; // Importing the SystemControl component
import TicketPoolStatus from './components/TicketPoolStatus'; // Importing the TicketPoolStatus component
import './styles.css'; // Importing the CSS file for styling

/**
 * Main Application component that brings together various child components.
 * Displays the Ticketing System header and arranges the child components into a layout.
 */
const App = () => {
    return (
        <div className="App">
            <h1>Ticketing System</h1> {/* Header of the application */}
            <div className="Content">
                {/* Left section for Logs */}
                <div className="Left">
                    <LogsTable/> {/* Displays logs fetched from the backend */}
                </div>

                {/* Right section for Configuration, Ticket Pool, and System Control */}
                <div className="Right">
                    <ConfigurationForm/> {/* Form for system configuration */}
                    <TicketPoolStatus/> {/* Displays the status of available tickets and system */}
                    <SystemControl/> {/* Buttons to start/stop the system */}
                </div>
            </div>
        </div>
    );
};

export default App;
