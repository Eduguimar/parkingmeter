package com.fiap.postech.parkingmeter.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ParkingFixedPeriodDTO {

    @NotNull(message = "Exit time required")
    private LocalDateTime exitTime;
    @NotNull(message = "Vehicle required")
    private Long vehicleId;

    public ParkingFixedPeriodDTO() {
    }

    public ParkingFixedPeriodDTO(LocalDateTime exitTime, Long vehicleId) {
        this.exitTime = exitTime;
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
