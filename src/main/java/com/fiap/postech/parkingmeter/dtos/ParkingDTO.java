package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Parking;
import com.fiap.postech.parkingmeter.models.Vehicle;

import java.time.LocalDateTime;

public class ParkingDTO {

    private Long id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double valuePerHour;

    private Vehicle vehicle;

    public ParkingDTO() {
    }

    public ParkingDTO(Long id, LocalDateTime entryTime, LocalDateTime exitTime, Double valuePerHour, Vehicle vehicle) {
        this.id = id;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.valuePerHour = valuePerHour;
        this.vehicle = vehicle;
    }

    public ParkingDTO(Parking parking) {
        this.id = parking.getId();
        this.entryTime = parking.getEntryTime();
        this.exitTime = parking.getExitTime();
        this.valuePerHour = parking.getValuePerHour();
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

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
