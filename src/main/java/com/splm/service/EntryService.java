package com.splm.service;

import com.splm.model.ParkingSpace;
import com.splm.model.Vehicle;
import com.splm.repository.ParkingSpaceRepository;
import com.splm.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public ParkingSpace allocateParkingSpace(Vehicle vehicle) {
        ParkingSpace availableSpace = parkingSpaceRepository.findFirstByAvailableTrueAndSize(vehicle.getType());
        if (availableSpace != null) {
            availableSpace.setAvailable(false);
            availableSpace.setAssignedVehicleId(vehicle.getId());
            parkingSpaceRepository.save(availableSpace);
            vehicle.setEntryTime(LocalDateTime.now());
            vehicleRepository.save(vehicle);
            return availableSpace;
        }
        return null;
    }

    public ParkingSpace checkIn(Vehicle vehicle) {
        ParkingSpace allocatedSpace = allocateParkingSpace(vehicle);
        if (allocatedSpace != null) {
            return allocatedSpace;
        } else {
            throw new RuntimeException("No available parking space for vehicle: " + vehicle.getId());
        }
    }

    public List<ParkingSpace> getAvailableSpaces() {
        return parkingSpaceRepository.findByAvailableTrue();
    }
}