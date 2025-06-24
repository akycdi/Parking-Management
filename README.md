# Smart Parking Lot Backend

This project is a backend system for managing a smart parking lot. It includes functionalities for vehicle entry and exit management, parking space allocation, and fee calculation.

## Project Structure

```
smart-parking-lot-backend
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── splm
│   │   │           ├── SmartParkingLotBackendApplication.java
│   │   │           ├── controller
│   │   │           │   ├── EntryController.java
│   │   │           │   ├── ExitController.java
│   │   │           │   └── ParkingSpaceController.java
│   │   │           ├── service
│   │   │           │   ├── EntryService.java
│   │   │           │   ├── ExitService.java
│   │   │           │   └── FeeCalculationService.java
│   │   │           ├── model
│   │   │           │   ├── Vehicle.java
│   │   │           │   ├── ParkingSpace.java
│   │   │           │   └── Ticket.java
│   │   │           └── repository
│   │   │               ├── VehicleRepository.java
│   │   │               ├── ParkingSpaceRepository.java
│   │   │               └── TicketRepository.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── splm
│                   └── SmartParkingLotBackendApplicationTests.java
├── pom.xml
└── README.md
```

## Features

- **Vehicle Entry Management**: Handles vehicle check-in and assigns parking spots based on availability.
- **Vehicle Exit Management**: Manages vehicle check-out and calculates parking fees based on duration of stay.
- **Parking Space Allocation**: Provides information on available parking spaces and their details.
- **Fee Calculation**: Calculates parking fees based on vehicle type and duration.
