package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.DriverDTO;
import com.fiap.postech.parkingmeter.services.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public Page<DriverDTO> findAll(PageRequest pageRequest) {
        return null;
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
