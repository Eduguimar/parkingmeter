package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Vehicle;
import jakarta.validation.constraints.NotBlank;

public class VehicleDTO {

    private Long id;
    private String model;
    @NotBlank(message = "License plate is required")
    private String licensePlate;
    private Integer year;
    private boolean isParkedPerHour;

    private DriverDTO driverDTO;

    private ParkingDTO parkingDTO;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, String model, String licensePlate, Integer year, boolean isParkedPerHour, DriverDTO driverDTO, ParkingDTO parkingDTO) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.isParkedPerHour = isParkedPerHour;
        this.driverDTO = driverDTO;
        this.parkingDTO = parkingDTO;
    }

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.model = vehicle.getModel();
        this.licensePlate = vehicle.getLicensePlate();
        this.year = vehicle.getYear();
        this.isParkedPerHour = vehicle.isParkedPerHour();
        this.driverDTO = new DriverDTO(vehicle.getDriver());
        this.parkingDTO = new ParkingDTO(vehicle.getParking());
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

    public DriverDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public ParkingDTO getParkingDTO() {
        return parkingDTO;
    }

    public void setParkingDTO(ParkingDTO parkingDTO) {
        this.parkingDTO = parkingDTO;
    }
}
