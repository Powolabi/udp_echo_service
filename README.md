# UDP Date and Time Service

## Overview

This project demonstrates a simple UDP-based client-server application that allows users to query a server for date and time information. The client sends a request to the server, and the server responds with either the current date (year, month, and day) or the current time (hour, minute, and seconds).

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Usage](#usage)
## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed on both the client and server machines.
- A code editor or IDE (e.g., IntelliJ IDEA, Eclipse) for development.
- Basic knowledge of Java programming.
- Two separate computers or virtual machines to run the client and server.

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/udp-date-time-service.git


##Project Structure
  
The project directory structure is organized as follows:

    udp_echo_service/: Contains the Java source code for the client and server.
    README.md: This README file.

## Usage
Server Configuration

    Ensure that the server and client machines are on the same network.

    Determine the server's IP address and choose an available UDP port (e.g., 3000) for the server to listen on.

    Modify the client's configuration to specify the server's IP address and port. This can be done by editing the EchoClient.java file:
