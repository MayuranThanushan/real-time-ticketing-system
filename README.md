# Ticketing System

## Overview
The Ticketing System is a simple Java-based application with a React front-end that allows users to manage tickets, view system logs, and perform CRUD operations on tickets. This system is implemented using core Java for the back-end and React for the front-end. The application also integrates with a MySQL database for data persistence, allowing for seamless management of tickets and logs.

## Features
- **Add Ticket**: Allows users to create new tickets with a unique ID.
- **View All Tickets**: Displays all the tickets that have been created.
- **Delete All Tickets**: Deletes all tickets from the system.
- **View Logs**: Displays a log of actions performed on tickets (e.g., ticket creation, deletion).
- **React Front-End**: Provides a user-friendly interface to interact with the ticketing system.

## Technologies Used
- **Java**: Core Java used for implementing business logic (back-end).
- **Spring Boot**: Used for building and managing the back-end services, including handling ticket and log data.
- **React**: Front-end JavaScript framework used to build the user interface, allowing users to interact with the ticketing system in a responsive manner.
- **MySQL Database**: Used for persisting ticket and log data.
- **Spring Data JPA**: Handles database interactions.
- **JavaScript**: For handling front-end logic in React.

## Setup Instructions

### Prerequisites
- Java 11 or higher
- Node.js and npm (for running the React front-end)
- MySQL Database (local or remote)
- Spring Boot Dependencies for web applications (e.g., spring-boot-starter-web, spring-boot-starter-data-jpa)

### Clone the Repository
```bash
git clone https://github.com/your-username/ticketing-system.git
cd ticketing-system
```

### Database Setup
1. Create a MySQL database named `ticketingsystem`.
2. Update the `application.properties` file with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ticketingsystem
   spring.datasource.username=<your-database-username>
   spring.datasource.password=<your-database-password>
   ```

### Back-End Setup
1. Navigate to the back-end directory and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
   This will start the back-end server on port `8080`.

### Front-End Setup (React)
1. Navigate to the `frontend` directory (or the React app folder):
   ```bash
   cd frontend
   ```
2. Install the necessary dependencies:
   ```bash
   npm install
   ```
3. Start the React development server:
   ```bash
   npm start
   ```
   This will run the React application on `http://localhost:3000`.

### Application Flow
1. The front-end (React) will interact with the back-end (Spring Boot) via HTTP requests.
2. The React app will send requests to the back-end API (on `http://localhost:8080`) to manage tickets and logs.

### Endpoints (Back-End)
- **POST** `/api/tickets`: Add a new ticket.
- **GET** `/api/tickets`: Get all tickets.
- **DELETE** `/api/tickets`: Delete all tickets.
- **GET** `/api/logs`: View all logs.