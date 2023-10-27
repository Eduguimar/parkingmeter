package com.fiap.postech.parkingmeter.models;

import com.fiap.postech.parkingmeter.models.enums.ParkingType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.Objects;

public class Parking {

    private Long id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double value;
    @Enumerated(EnumType.STRING)
    private ParkingType parkingType;

    private Vehicle vehicle;

    public Parking() {
    }

    public Parking(Long id, LocalDateTime entryTime, LocalDateTime exitTime, Double value, ParkingType parkingType, Vehicle vehicle) {
        this.id = id;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.value = value;
        this.parkingType = parkingType;
        this.vehicle = vehicle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(id, parking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
