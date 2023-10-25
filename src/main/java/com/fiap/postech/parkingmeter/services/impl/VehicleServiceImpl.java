package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.services.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public Page<VehicleDTO> findAll(PageRequest pageRequest) {
        return null;
    }

    @Override
    public VehicleDTO findById(Long id) {
        return null;
    }

    @Override
    public VehicleDTO save(VehicleDTO driverDTO) {
        return null;
    }

    @Override
    public VehicleDTO update(Long id, VehicleDTO driverDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
