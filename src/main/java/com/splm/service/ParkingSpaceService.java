package com.splm.service;

import com.splm.model.ParkingSpace;
import com.splm.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    public ParkingSpace getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Parking space not found"));
    }

    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaceRepository.findByAvailableTrue();
    }
}