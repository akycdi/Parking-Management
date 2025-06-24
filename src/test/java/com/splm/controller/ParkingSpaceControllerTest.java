package com.splm.controller;

import com.splm.model.ParkingSpace;
import com.splm.repository.ParkingSpaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingSpaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @BeforeEach
    void setup() {
        ParkingSpace ps = new ParkingSpace();
        ps.setSize("car");
        ps.setAvailable(true);
        parkingSpaceRepository.save(ps);
    }

    @Test
    void testGetAllParkingSpaces() throws Exception {
        mockMvc.perform(get("/parking-spaces"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())));
    }

    @Test
    void testGetAvailableParkingSpaces() throws Exception {
        mockMvc.perform(get("/parking-spaces/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())));
    }
}