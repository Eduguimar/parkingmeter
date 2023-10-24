package com.fiap.postech.parkingmeter.repositories;

import com.fiap.postech.parkingmeter.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
