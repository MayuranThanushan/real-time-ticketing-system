import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api'; // Backend API URL

/**
 * Starts the system by calling the backend API endpoint.
 * Logs the response from the backend and returns the response data.
 *
 * @async
 * @returns {Promise<Object>} Response data from the backend
 * @throws {Error} If there is an error in the request
 */
export const startSystem = async () => {
    try {
        const response = await axios.post(`${API_BASE_URL}/start`);
        console.log('Start system response:', response.data); // Log the response from the backend
        return response.data;  // Return the response from the backend
    } catch (error) {
        console.error('Error starting system:', error); // Log any error
        throw error;  // Throw the error so it can be handled in the frontend
    }
};

/**
 * Stops the system by calling the backend API endpoint.
 * Logs the response from the backend and returns the response data.
 *
 * @async
 * @returns {Promise<Object>} Response data from the backend
 * @throws {Error} If there is an error in the request
 */
export const stopSystem = async () => {
    try {
        const response = await axios.post(`${API_BASE_URL}/stop`);
        console.log('Stop system response:', response.data); // Log the response from the backend
        return response.data;  // Return the response from the backend
    } catch (error) {
        console.error('Error stopping the system:', error); // Log any error
        throw error;  // Throw the error so it can be handled in the frontend
    }
};

/**
 * Fetches the logs from the backend API.
 * Logs the response from the backend and returns the response data.
 *
 * @async
 * @returns {Promise<Array>} List of logs fetched from the backend
 * @throws {Error} If there is an error in the request
 */
export const getLogs = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/logs`);
        console.log('Logs fetched:', response.data); // Log the logs data from the backend
        return response.data; // Return the fetched logs
    } catch (error) {
        console.error('Error fetching logs:', error); // Log any error
        throw error; // Throw the error so it can be handled in the frontend
    }
};

/**
 * Fetches the current status of the system from the backend API.
 * Logs the response from the backend and returns the response data.
 *
 * @async
 * @returns {Promise<Object>} Current system status from the backend
 * @throws {Error} If there is an error in the request
 */
export const getStatus = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/status`);
        console.log('Status fetched:', response.data); // Log the status data from the backend
        return response.data;  // Return the current status
    } catch (error) {
        console.error('Error fetching status:', error); // Log any error
        throw error;  // Throw the error so it can be handled in the frontend
    }
};
