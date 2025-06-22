package com.splm.controller;

import com.splm.service.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exit")
public class ExitController {

    @Autowired
    private ExitService exitService;

    @PostMapping("/{ticketId}")
    public ResponseEntity<String> checkoutVehicle(@PathVariable Long ticketId) {
        exitService.checkoutVehicle(ticketId);
        return ResponseEntity.ok("Vehicle checked out successfully.");
    }
}