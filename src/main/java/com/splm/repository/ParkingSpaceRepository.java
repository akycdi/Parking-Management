package com.splm.repository;

import com.splm.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByAvailableTrue();
    ParkingSpace findFirstByAvailableTrueAndSize(String size);
}