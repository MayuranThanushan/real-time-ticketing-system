import React, { useEffect, useState } from 'react';
import { getLogs } from '../services/api';

/**
 * LogsTable component fetches and displays system logs in a table format.
 * The logs are fetched initially and periodically every 5 seconds.
 *
 * @component
 */
const LogsTable = () => {
    // State variable to hold logs data
    const [logs, setLogs] = useState([]);

    /**
     * Fetches logs from the backend and updates the state.
     * Catches any errors during the fetch operation.
     *
     * @async
     */
    const fetchLogs = async () => {
        try {
            const data = await getLogs();  // Fetch logs from backend
            setLogs(data);  // Update logs state with fetched data
        } catch (error) {
            console.error('Error fetching logs:', error);  // Log any errors
        }
    };

    // Effect hook to fetch logs on initial render and set up periodic polling
    useEffect(() => {
        fetchLogs();  // Fetch logs immediately upon component mount
        const intervalId = setInterval(fetchLogs, 5000); // Poll logs every 5 seconds
        return () => clearInterval(intervalId);  // Cleanup interval on component unmount
    }, []);

    return (
        <div>
            <h3>System Logs</h3>
            <table>
                <thead>
                    <tr>
                        <th>Timestamp</th>
                        <th>Action</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    {/* Loop through logs and display each log entry in a table row */}
                    {logs.map((log, index) => (
                        <tr key={index} style={log.action === "Purchase" ? { color: "green" } : {}}>
                            <td>{log.timestamp}</td>
                            <td>{log.action}</td>
                            <td>{log.details}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default LogsTable;
