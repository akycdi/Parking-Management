package com.splm;

import com.splm.model.ParkingSpace;
import com.splm.repository.ParkingSpaceRepository;
import com.splm.repository.VehicleRepository;
import com.splm.repository.TicketRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SmartParkingLotIntegrationTest {


    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired

    @BeforeEach
    void setup() {
        ticketRepository.deleteAll();
        vehicleRepository.deleteAll();
        parkingSpaceRepository.deleteAll();

        ParkingSpace ps = new ParkingSpace();
        ps.setSize("car");
        ps.setAvailable(true);
        parkingSpaceRepository.save(ps);
    }

    @AfterEach
    void cleanup() {
        ticketRepository.deleteAll();
        vehicleRepository.deleteAll();
        parkingSpaceRepository.deleteAll();
    }

    @Test
    void testFullCheckInAndExitFlow() throws Exception {
        //need to complete the test for check-in and exit flow
    }
}