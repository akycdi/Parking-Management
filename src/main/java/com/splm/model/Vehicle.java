package com.splm.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    @Id
    private String id; 
    private String license;
    private String type;
    private LocalDateTime entryTime;
}