package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.ParkingDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryEntryDTO;
import com.fiap.postech.parkingmeter.dtos.SummaryExitDTO;
import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.Parking;
import com.fiap.postech.parkingmeter.models.enums.ParkingType;
import com.fiap.postech.parkingmeter.repositories.ParkingRepository;
import com.fiap.postech.parkingmeter.repositories.VehicleRepository;
import com.fiap.postech.parkingmeter.services.ParkingService;
import com.fiap.postech.parkingmeter.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    ParkingRepository parkingRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public ParkingDTO createFixedPeriodEntry(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        mapperDtoToEntity(parkingDTO, parking);
        parking.setEntryTime(LocalDateTime.now());
        parking.setValue(calculatePrice(parking.getEntryTime(), parking.getExitTime()));
        parking.setNextNotificationDate(parking.getExitTime().minusMinutes(10));

        var savedParking = parkingRepository.save(parking);
        return new ParkingDTO(savedParking);
    }

    @Override
    @Transactional
    public SummaryEntryDTO createPerHourEntry(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        mapperDtoToEntity(parkingDTO, parking);
        if (parking.getVehicle().isParkedPerHour()) {
            throw new RuntimeException("Vehicle already parked");
        }
        parking.setEntryTime(LocalDateTime.now());
        parking.getVehicle().setParkedPerHour(true);
        parking.setNextNotificationDate(parking.getEntryTime().plusMinutes(50));

        var savedParking = parkingRepository.save(parking);

        return createSummaryEntry(savedParking);
    }

    @Override
    @Transactional
    public SummaryExitDTO createExitPerHour(Long parkingId) {
        Parking parking = parkingRepository.findById(parkingId).orElseThrow(() -> new ControllerNotFoundException("Parking not found"));
        parking.setExitTime(LocalDateTime.now());
        parking.getVehicle().setParkedPerHour(false);
        SummaryExitDTO summary = createSummaryExit(parking);
        parking.setValue(summary.getTotalValue());
        parking.setNextNotificationDate(null);

        parkingRepository.save(parking);

        return summary;
    }

    @Override
    @Transactional
    public void updateNextNotificationDate(Parking parking) {
        LocalDateTime nextNotificationDate = parking.getParkingType().equals(ParkingType.PER_HOUR) ? LocalDateTime.now().plusHours(1) : null;

        parking.setNextNotificationDate(nextNotificationDate);
        parkingRepository.save(parking);
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
    public SummaryEntryDTO createSummaryEntry(Parking parking) {
        SummaryEntryDTO summaryEntry = new SummaryEntryDTO();
        summaryEntry.setId(parking.getId());
        summaryEntry.setEntryTime(parking.getEntryTime().toString());
        summaryEntry.setParkingType(parking.getParkingType());
        summaryEntry.setVehicleDTO(new VehicleDTO(parking.getVehicle()));

        return summaryEntry;
    }

    @Override
    public SummaryExitDTO createSummaryExit(Parking parking) {
        var timeDuration =  Duration.between(parking.getEntryTime(), parking.getExitTime());
        long totalParkedHours = timeDuration.toHours();
        double totalValue = calculatePrice(parking.getEntryTime(), parking.getExitTime());

        SummaryExitDTO summaryExitDTO = new SummaryExitDTO();
        summaryExitDTO.setId(parking.getId());
        summaryExitDTO.setEntryTime(parking.getEntryTime().toString());
        summaryExitDTO.setExitTime(parking.getExitTime().toString());
        summaryExitDTO.setVehicleDTO(new VehicleDTO(parking.getVehicle()));
        summaryExitDTO.setTotalParkingTimeInHours(totalParkedHours);
        summaryExitDTO.setTotalValue(totalValue);

        return summaryExitDTO;
    }

    private void mapperDtoToEntity(ParkingDTO dto, Parking parking) {
        parking.setEntryTime(dto.getEntryTime());
        parking.setExitTime(dto.getExitTime());
        parking.setValue(dto.getValue());
        parking.setParkingType(dto.getParkingType());
        parking.setVehicle(vehicleRepository.getOne(dto.getVehicleId()));
    }
}
