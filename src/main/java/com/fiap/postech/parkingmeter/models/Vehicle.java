package com.fiap.postech.parkingmeter.models;

import java.util.Objects;

public class Vehicle {

    private Long id;
    private String model;
    private String licensePlate;
    private Integer year;

    private Driver driver;

    public Vehicle(){
    }

    public Vehicle(Long id, String model, String licensePlate, Integer year, Driver driver) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.driver = driver;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
