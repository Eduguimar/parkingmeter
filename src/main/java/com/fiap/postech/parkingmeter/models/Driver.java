package com.fiap.postech.parkingmeter.models;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Driver {

    private Long id;
    private String name;
    private String document;
    private Date birthDate;
    private String mail;
    private String phone;

    private Set<Vehicle> vehicles;

    public Driver() {
    }

    public Driver(Long id, String name, String document, Date birthDate, String mail, String phone, Set<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.mail = mail;
        this.phone = phone;
        this.vehicles = vehicles;
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

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
