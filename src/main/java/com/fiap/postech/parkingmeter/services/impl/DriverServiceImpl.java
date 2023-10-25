package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.DriverDTO;
import com.fiap.postech.parkingmeter.models.Driver;
import com.fiap.postech.parkingmeter.repositories.DriverRepository;
import com.fiap.postech.parkingmeter.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Page<DriverDTO> findAll(PageRequest pageRequest) {
        Page<Driver> drivers = driverRepository.findAll(pageRequest);
        return drivers.map(driver -> new DriverDTO(driver, driver.getVehicles()));
    }

    @Override
    public DriverDTO findById(Long id) {
        return null;
    }

    @Override
    public DriverDTO save(DriverDTO driverDTO) {
        return null;
    }

    @Override
    public DriverDTO update(Long id, DriverDTO driverDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
