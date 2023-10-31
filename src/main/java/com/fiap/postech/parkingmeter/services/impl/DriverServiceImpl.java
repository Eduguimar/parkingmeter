package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.DriverDTO;
import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.Driver;
import com.fiap.postech.parkingmeter.models.Vehicle;
import com.fiap.postech.parkingmeter.repositories.DriverRepository;
import com.fiap.postech.parkingmeter.repositories.VehicleRepository;
import com.fiap.postech.parkingmeter.services.DriverService;
import com.fiap.postech.parkingmeter.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<DriverDTO> findAll(PageRequest pageRequest) {
        Page<Driver> drivers = driverRepository.findAll(pageRequest);
        return drivers.map(driver -> new DriverDTO(driver, driver.getVehicles()));
    }

    @Override
    @Transactional(readOnly = true)
    public DriverDTO findById(Long id) {
        var driver = driverRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Driver not found"));
        return new DriverDTO(driver, driver.getVehicles());
    }

    @Override
    @Transactional
    public DriverDTO save(DriverDTO driverDTO) {
        Driver driver = new Driver();
        mapperDtoToEntity(driverDTO, driver);
        Driver savedDriver = driverRepository.save(driver);
        return new DriverDTO(savedDriver, savedDriver.getVehicles());
    }

    @Override
    @Transactional
    public DriverDTO update(Long id, DriverDTO driverDTO) {
        try {
            Driver driver = driverRepository.getOne(id);
            mapperDtoToEntity(driverDTO, driver);
            return new DriverDTO(driver, driver.getVehicles());
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Driver not found, id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            driverRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Driver not found, id: " + id);
        }
    }

    private void mapperDtoToEntity(DriverDTO dto, Driver driver) {
        driver.setName(dto.getName());
        driver.setDocument(dto.getDocument());
        driver.setBirthDate(dto.getBirthDate());
        driver.setMail(dto.getMail());
        driver.setPhone(dto.getPhone());
        driver.setPaymentForm(dto.getPaymentForm());

        for (VehicleDTO vehicleDTO : dto.getVehicles()) {
            Vehicle vehicle = vehicleRepository.getOne(vehicleDTO.getId());
            driver.getVehicles().add(vehicle);
        }
    }
}
