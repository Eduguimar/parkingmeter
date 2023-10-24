package com.fiap.postech.parkingmeter.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Parking {

    private Long id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double valuePerHour;

    private Vehicle vehicle;

    public Parking() {
    }

    public Parking(Long id, LocalDateTime entryTime, LocalDateTime exitTime, Double valuePerHour, Vehicle vehicle) {
        this.id = id;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.valuePerHour = valuePerHour;
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
