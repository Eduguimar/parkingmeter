package com.fiap.postech.parkingmeter.controllers;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.ParkingFixedPeriodDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryDTO;
import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.enums.ParkingType;
import com.fiap.postech.parkingmeter.services.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        parkingDTO.setVehicleDTO(parkingFixedPeriodDTO.getVehicleDTO());
        var savedParking = parkingService.createFixedPeriodEntry(parkingDTO);

        return ResponseEntity.ok(savedParking);
    }

    @PostMapping(value = "/createEntryPerHour")
    public ResponseEntity<ParkingDTO> createEntryPerHour(@Valid @RequestBody VehicleDTO vehicleDTO) {
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setParkingType(ParkingType.PER_HOUR);
        parkingDTO.setVehicleDTO(vehicleDTO);
        var savedParking = parkingService.createPerHourEntry(parkingDTO);

        return ResponseEntity.ok(savedParking);
    }

    @PostMapping(value = "/createExitPerHour")
    public ResponseEntity<SummaryDTO> createExitPerHour(@Valid @RequestBody VehicleDTO vehicleDTO) {
        SummaryDTO summary = parkingService.createExitPerHour(vehicleDTO);

        return ResponseEntity.ok(summary);
    }
}
