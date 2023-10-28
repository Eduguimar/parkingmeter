package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryDTO;
import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.Parking;
import com.fiap.postech.parkingmeter.repositories.ParkingRepository;
import com.fiap.postech.parkingmeter.repositories.VehicleRepository;
import com.fiap.postech.parkingmeter.services.ParkingService;
import com.fiap.postech.parkingmeter.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    ParkingRepository parkingRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public ParkingDTO createFixedPeriodEntry(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        mapperDtoToEntity(parkingDTO, parking);
        parking.setEntryTime(LocalDateTime.now());
        parking.setValue(calculatePrice(parking.getEntryTime(), parking.getExitTime()));

        var savedParking = parkingRepository.save(parking);
        return new ParkingDTO(savedParking);
    }

    @Override
    public ParkingDTO createPerHourEntry(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        mapperDtoToEntity(parkingDTO, parking);
        parking.setEntryTime(LocalDateTime.now());
        parking.getVehicle().setParkedPerHour(true);

        var savedParking = parkingRepository.save(parking);
        return new ParkingDTO(savedParking);
    }

    @Override
    public SummaryDTO createExitPerHour(VehicleDTO vehicleDTO) {
        Parking parking = parkingRepository.findByVehicleId(vehicleDTO.getId());
        if (parking == null) {
            throw new ControllerNotFoundException("Parking not found");
        }
        parking.setExitTime(LocalDateTime.now());
        parking.getVehicle().setParkedPerHour(false);

        var savedParking = parkingRepository.save(parking);
        return createSummary(savedParking);
    }


    @Override
    public double calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime) {
        // Constants for pricing
        final double DAILY_RATE = 23.00;
        final double QUARTER_HOUR_RATE = 1.00;
        final double HOUR_RATE = 5.00;
        final double ADDITIONAL_RATE = 2.00;

        var timeDuration =  Duration.between(entryTime, exitTime);
        long minutes = timeDuration.toMinutes();

        if (minutes == 1440) {
            return DAILY_RATE;
        } else if (minutes <= 15) {
            return QUARTER_HOUR_RATE;
        } else if (minutes == 60) {
            return HOUR_RATE;
        } else {
            double additionalHours = Math.ceil((minutes - 60) / 60.0);
            return HOUR_RATE + (additionalHours * ADDITIONAL_RATE);
        }
    }

    @Override
    public SummaryDTO createSummary(Parking parking) {
        var timeDuration =  Duration.between(parking.getEntryTime(), parking.getExitTime());
        long totalParkedHours = timeDuration.toHours();
        double totalValue = calculatePrice(parking.getEntryTime(), parking.getExitTime());

        SummaryDTO summaryDTO = new SummaryDTO();
        summaryDTO.setEntryTime(parking.getEntryTime().toString());
        summaryDTO.setExitTime(parking.getExitTime().toString());
        summaryDTO.setVehicleDTO(new VehicleDTO(parking.getVehicle()));
        summaryDTO.setTotalParkingTimeInHours(totalParkedHours);
        summaryDTO.setTotalValue(totalValue);

        return summaryDTO;
    }

    private void mapperDtoToEntity(ParkingDTO dto, Parking parking) {
        parking.setEntryTime(dto.getEntryTime());
        parking.setExitTime(dto.getExitTime());
        parking.setValue(dto.getValue());
        parking.setParkingType(dto.getParkingType());
        parking.setVehicle(vehicleRepository.getOne(dto.getVehicleDTO().getId()));
    }

}
