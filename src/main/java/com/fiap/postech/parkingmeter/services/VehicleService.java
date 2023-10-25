package com.fiap.postech.parkingmeter.services;

import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface VehicleService {

    Page<VehicleDTO> findAll(PageRequest pageRequest);

    VehicleDTO findById(Long id);

    VehicleDTO save(VehicleDTO driverDTO);

    VehicleDTO update(Long id, VehicleDTO driverDTO);

    void delete(Long id);
}
