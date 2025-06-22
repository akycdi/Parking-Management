package com.splm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private boolean available = true;
    private String assignedVehicleId;
}