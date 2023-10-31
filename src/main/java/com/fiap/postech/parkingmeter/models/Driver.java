package com.fiap.postech.parkingmeter.models;

import com.fiap.postech.parkingmeter.models.enums.PaymentForm;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date birthDate;
    private String mail;
    private String phone;
    @Enumerated(EnumType.STRING)
    private PaymentForm paymentForm;

    @OneToMany(mappedBy = "driver")
    private Set<Vehicle> vehicles = new HashSet<>();

    public Driver() {
    }

    public Driver(Long id, String name, String document, Date birthDate, String mail, String phone, PaymentForm paymentForm, Set<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.mail = mail;
        this.phone = phone;
        this.paymentForm = paymentForm;
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

    public PaymentForm getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
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
