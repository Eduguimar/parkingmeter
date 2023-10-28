package com.fiap.postech.parkingmeter.services;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryDTO;
import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.Parking;

import java.time.LocalDateTime;

public interface ParkingService {

    ParkingDTO createFixedPeriodEntry(ParkingDTO parkingDTO);

    ParkingDTO createPerHourEntry(ParkingDTO parkingDTO);

    SummaryDTO createExitPerHour(VehicleDTO vehicleDTO);

    double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime);

    SummaryDTO createSummary(Parking parking);
}
