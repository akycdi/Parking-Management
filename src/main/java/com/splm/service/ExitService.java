package com.splm.service;

import com.splm.model.ParkingSpace;
import com.splm.model.Ticket;
import com.splm.repository.ParkingSpaceRepository;
import com.splm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ExitService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FeeCalculationService feeCalculationService;

     @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;


     public void checkoutVehicle(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setExitTime(LocalDateTime.now());
        double fee = feeCalculationService.calculateFee(
            ticket.getVehicleType(),
            ticket.getEntryTime(),
            ticket.getExitTime()
        );
        ticket.setFee(fee);

        if (ticket.getParkingSpaceId() != null) {
            ParkingSpace parkingSpace = parkingSpaceRepository.findById(ticket.getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("Parking space not found"));
            parkingSpace.setAvailable(true);
            parkingSpace.setAssignedVehicleId(null);
            parkingSpaceRepository.save(parkingSpace);
        }

        ticketRepository.save(ticket);
    }

    public Ticket getTicketDetails(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public double calculateFee(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        return feeCalculationService.calculateFee(
            ticket.getVehicleType(),
            ticket.getEntryTime(),
            ticket.getExitTime()
        );
    }

    public void updateTicketFee(Long ticketId, double fee) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setFee(fee); 
        ticketRepository.save(ticket);
    }
}