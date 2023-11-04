package com.fiap.postech.parkingmeter.repositories;

import com.fiap.postech.parkingmeter.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    Parking findByVehicleId(Long vehicleId);

    List<Parking> findByNextNotificationDateIsLessThanEqual(LocalDateTime nextNotificationDate);
}
