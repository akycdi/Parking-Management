package com.splm.service;

import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class FeeCalculationService {

    private static final double CAR_RATE_PER_HOUR = 2.0;
    private static final double MOTORCYCLE_RATE_PER_HOUR = 1.0;
    private static final double BUS_RATE_PER_HOUR = 3.0;

    public double calculateFee(String vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();
        double rate = getRate(vehicleType);
        return hours * rate;
    }

    private double getRate(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return CAR_RATE_PER_HOUR;
            case "motorcycle":
                return MOTORCYCLE_RATE_PER_HOUR;
            case "bus":
                return BUS_RATE_PER_HOUR;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}