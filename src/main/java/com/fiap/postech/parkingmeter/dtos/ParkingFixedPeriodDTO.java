package com.fiap.postech.parkingmeter.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ParkingFixedPeriodDTO {

    @NotBlank(message = "Exit time required")
    private LocalDateTime exitTime;
    @NotBlank(message = "Vehicle required")
    private VehicleDTO vehicleDTO;

    public ParkingFixedPeriodDTO() {
    }

    public ParkingFixedPeriodDTO(LocalDateTime exitTime, VehicleDTO vehicleDTO) {
        this.exitTime = exitTime;
        this.vehicleDTO = vehicleDTO;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
