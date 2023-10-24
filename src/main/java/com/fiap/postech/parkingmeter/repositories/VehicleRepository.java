package com.fiap.postech.parkingmeter.repositories;

import com.fiap.postech.parkingmeter.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
