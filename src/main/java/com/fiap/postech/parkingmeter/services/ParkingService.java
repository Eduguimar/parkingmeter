package com.fiap.postech.parkingmeter.services;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryEntryDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryExitDTO;
import com.fiap.postech.parkingmeter.models.Parking;

import java.time.LocalDateTime;

public interface ParkingService {

    ParkingDTO createFixedPeriodEntry(ParkingDTO parkingDTO);

    SummaryEntryDTO createPerHourEntry(ParkingDTO parkingDTO);

    SummaryExitDTO createExitPerHour(Long parkingId);

    double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime);

    SummaryEntryDTO createSummaryEntry(Parking parking);

    SummaryExitDTO createSummaryExit(Parking parking);

    void updateNextNotificationDate(Parking parking);
}
