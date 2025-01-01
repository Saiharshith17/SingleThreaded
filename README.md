# Server-Client Communication Models

This repository demonstrates the implementation of various server-client communication models in Java. It highlights the differences in concurrency techniques and their trade-offs in terms of scalability, performance, and resource management.

## Directory Structure
Directory structure:
Saiharshith17-SingleThreaded/
├── SingleThread/
│   ├── Server.java # Single-threaded server implementation
│   └── Client.java # Client for single-threaded server
├── ThreadPool/
│   └── Server.java # Server implementation using a thread pool
└── MultiThreaded/
    ├── Server.java # Multi-threaded server implementation
    └── Client.java # Client for multi-threaded server


## Description of Models
1. **Single-Threaded Server**:
   - Handles one client at a time.
   - Simple to implement but inefficient for multiple clients as requests are processed sequentially.

2. **Multi-Threaded Server**:
   - Creates a new thread for each client connection.
   - Improves responsiveness but can lead to resource exhaustion under high client loads.

3. **Thread-Pool Server**:
   - Uses a fixed pool of threads to handle multiple client requests.
   - Balances performance and resource usage effectively.

## Features
- **Socket Programming**: Enables communication between server and client over TCP/IP.
- **Multithreading**: Explores different threading models to improve server performance.
- **Thread Pools**: Implements efficient resource management for handling multiple client requests.

## Tech Stack
- **Language**: Java
- **Core Concepts**: Sockets, Multithreading, Thread Pools
- **Tools**: JDK, IntelliJ IDEA/Eclipse
- **Platform**: Java Runtime Environment (JRE)

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/Saiharshith17-SingleThreaded.git
   cd Saiharshith17-SingleThreaded
2. Navigate to the desired implementation directory (e.g., SingleThread, MultiThreaded, or ThreadPool).
3. Compile the server and client code:
javac Server.java Client.java
4. Start the server:
java Server
5. Start the client in a separate terminal:
   java Client
