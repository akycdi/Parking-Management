package com.splm.controller;

import com.splm.model.Vehicle;
import com.splm.model.ParkingSpace;
import com.splm.service.EntryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/checkin")
    public ResponseEntity<ParkingSpace> checkInVehicle(@RequestBody Vehicle vehicle) {
        ParkingSpace allocatedSpace = entryService.checkIn(vehicle);
        return ResponseEntity.ok(allocatedSpace);
    }

    @GetMapping("/available-spaces")
    public ResponseEntity<List<ParkingSpace>> getAvailableSpaces() {
        List<ParkingSpace> availableSpaces = entryService.getAvailableSpaces();
        return ResponseEntity.ok(availableSpaces);
    }
}