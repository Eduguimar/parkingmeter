package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.Driver;
import com.fiap.postech.parkingmeter.models.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DriverDTO {

    private Long id;
    private String name;
    private String document;
    private Date birthDate;
    private String mail;
    private String phone;

    private List<VehicleDTO> vehicles = new ArrayList<>();

    public DriverDTO() {
    }

    public DriverDTO(Long id, String name, String document, Date birthDate, String mail, String phone) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.mail = mail;
        this.phone = phone;
    }

    public DriverDTO(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.document = driver.getDocument();
        this.birthDate = driver.getBirthDate();
        this.mail = driver.getMail();
        this.phone = driver.getPhone();
    }

    public DriverDTO(Driver driver, Set<Vehicle> vehicles) {
        this(driver);
        vehicles.forEach(vehicle -> this.vehicles.add(new VehicleDTO(vehicle)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }
}
