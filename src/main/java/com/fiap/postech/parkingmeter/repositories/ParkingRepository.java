package com.fiap.postech.parkingmeter.repositories;

import com.fiap.postech.parkingmeter.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
