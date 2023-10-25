package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Driver;
import com.fiap.postech.parkingmeter.models.Vehicle;

public class VehicleDTO {

    private Long id;
    private String model;
    private String licensePlate;
    private Integer year;

    private Driver driver;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, String model, String licensePlate, Integer year, Driver driver) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.driver = driver;
    }

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.model = vehicle.getModel();
        this.licensePlate = vehicle.getLicensePlate();
        this.year = vehicle.getYear();
        this.driver = vehicle.getDriver();
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
