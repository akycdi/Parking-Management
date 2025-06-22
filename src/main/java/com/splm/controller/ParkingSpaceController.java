package com.splm.controller;

import com.splm.model.ParkingSpace;
import com.splm.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @GetMapping("/parking-spaces")
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }

    @GetMapping("/parking-spaces/{id}")
    public ParkingSpace getParkingSpaceById(@PathVariable Long id) {
        return parkingSpaceService.getParkingSpaceById(id);
    }

    @GetMapping("/parking-spaces/available")
    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaceService.getAvailableParkingSpaces();
    }
}