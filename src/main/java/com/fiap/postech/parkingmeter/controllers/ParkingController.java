package com.fiap.postech.parkingmeter.controllers;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.ParkingFixedPeriodDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryEntryDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryExitDTO;
import com.fiap.postech.parkingmeter.models.enums.ParkingType;
import com.fiap.postech.parkingmeter.services.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @PostMapping(value = "/createEntryFixedPeriod")
    public ResponseEntity<ParkingDTO> createEntryFixedPeriod(@Valid @RequestBody ParkingFixedPeriodDTO parkingFixedPeriodDTO) {
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setParkingType(ParkingType.FIXED_PERIOD);
        parkingDTO.setExitTime(parkingFixedPeriodDTO.getExitTime());
        parkingDTO.setVehicleId(parkingFixedPeriodDTO.getVehicleId());
        var savedParking = parkingService.createFixedPeriodEntry(parkingDTO);

        return ResponseEntity.ok(savedParking);
    }

    @PostMapping(value = "/createEntryPerHour")
    public ResponseEntity<SummaryEntryDTO> createEntryPerHour(@RequestBody Long vehicleId) {
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setParkingType(ParkingType.PER_HOUR);
        parkingDTO.setVehicleId(vehicleId);
        SummaryEntryDTO summary = parkingService.createPerHourEntry(parkingDTO);

        return ResponseEntity.ok(summary);
    }

    @PostMapping(value = "/createExitPerHour")
    public ResponseEntity<SummaryExitDTO> createExitPerHour(@RequestBody Long parkingId) {
        SummaryExitDTO summary = parkingService.createExitPerHour(parkingId);

        return ResponseEntity.ok(summary);
    }
}
