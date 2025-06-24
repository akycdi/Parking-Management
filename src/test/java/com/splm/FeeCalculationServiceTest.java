package com.splm;

import org.junit.jupiter.api.Test;

import com.splm.service.FeeCalculationService;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FeeCalculationServiceTest {

    private final FeeCalculationService service = new FeeCalculationService();

    @Test
    void testCarFeeCalculation() {
        LocalDateTime entry = LocalDateTime.now().minusHours(3);
        LocalDateTime exit = LocalDateTime.now();
        double fee = service.calculateFee("car", entry, exit);
        assertEquals(6.0, fee);
    }

    @Test
    void testMotorcycleFeeCalculation() {
        LocalDateTime entry = LocalDateTime.now().minusHours(2);
        LocalDateTime exit = LocalDateTime.now();
        double fee = service.calculateFee("motorcycle", entry, exit);
        assertEquals(2.0, fee);
    }

    @Test
    void testBusFeeCalculation() {
        LocalDateTime entry = LocalDateTime.now().minusHours(1);
        LocalDateTime exit = LocalDateTime.now();
        double fee = service.calculateFee("bus", entry, exit);
        assertEquals(3.0, fee);
    }

    @Test
    void testUnknownTypeThrows() {
        LocalDateTime entry = LocalDateTime.now().minusHours(1);
        LocalDateTime exit = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () ->
            service.calculateFee("truck", entry, exit)
        );
    }
}