package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {

    private Long id;
    private String model;
    @NotBlank(message = "License plate is required")
    private String licensePlate;
    private Integer year;
    private boolean isParkedPerHour;

    @NotNull
    private Long driverId;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, String model, String licensePlate, Integer year, boolean isParkedPerHour, Long driverId) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.isParkedPerHour = isParkedPerHour;
        this.driverId = driverId;
    }

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.model = vehicle.getModel();
        this.licensePlate = vehicle.getLicensePlate();
        this.year = vehicle.getYear();
        this.isParkedPerHour = vehicle.isParkedPerHour();
        this.driverId = vehicle.getDriver().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isParkedPerHour() {
        return isParkedPerHour;
    }

    public void setParkedPerHour(boolean parkedPerHour) {
        isParkedPerHour = parkedPerHour;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
