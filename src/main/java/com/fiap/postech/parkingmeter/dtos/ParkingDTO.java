package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Parking;
import com.fiap.postech.parkingmeter.models.Vehicle;
import com.fiap.postech.parkingmeter.models.enums.ParkingType;

import java.time.LocalDateTime;

public class ParkingDTO {

    private Long id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double value;
    private ParkingType parkingType;

    private Vehicle vehicle;

    public ParkingDTO() {
    }

    public ParkingDTO(Long id, LocalDateTime entryTime, LocalDateTime exitTime, Double value, ParkingType parkingType, Vehicle vehicle) {
        this.id = id;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.value = value;
        this.parkingType = parkingType;
        this.vehicle = vehicle;
    }

    public ParkingDTO(Parking parking) {
        this.id = parking.getId();
        this.entryTime = parking.getEntryTime();
        this.exitTime = parking.getExitTime();
        this.value = parking.getValue();
        this.parkingType = parking.getParkingType();
        this.vehicle = parking.getVehicle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
