import React, { useState } from 'react';
import { startSystem, stopSystem } from '../services/api';

/**
 * SystemControl component provides buttons to start and stop the system.
 * It interacts with the backend API to control the system's state.
 * The buttons are disabled based on whether the system is running or not.
 *
 * @component
 */
const SystemControl = () => {
    // State variable to track if the system is running or stopped
    const [systemRunning, setSystemRunning] = useState(false);

    /**
     * Handles starting the system by calling the backend API.
     * If successful, it updates the state to reflect the system is running.
     * 
     * @async
     */
    const handleStart = async () => {
        try {
            const response = await startSystem();  // Call backend to start the system
            console.log(response);  // Log the response from the backend
            setSystemRunning(true);  // Update state to indicate system is running
        } catch (error) {
            console.error('Error starting the system:', error);  // Log any error
            alert('Error starting the system');  // Show alert on error
        }
    };

    /**
     * Handles stopping the system by calling the backend API.
     * If successful, it updates the state to reflect the system is stopped.
     * 
     * @async
     */
    const handleStop = async () => {
        try {
            const response = await stopSystem();  // Call backend to stop the system
            console.log(response);  // Log the response from the backend
            setSystemRunning(false);  // Update state to indicate system is stopped
        } catch (error) {
            console.error('Error stopping the system:', error);  // Log any error
            alert('Error stopping the system');  // Show alert on error
        }
    };

    return (
        <div className="btn">
            {/* Button to start the system, disabled if the system is already running */}
            <button className="Start" onClick={handleStart} disabled={systemRunning}>
                Start System
            </button>
            {/* Button to stop the system, disabled if the system is not running */}
            <button className="Stop" onClick={handleStop} disabled={!systemRunning}>
                Stop System
            </button>
        </div>
    );
};

export default SystemControl;
