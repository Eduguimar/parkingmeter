package com.fiap.postech.parkingmeter.services;

import com.fiap.postech.parkingmeter.dtos.DriverDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DriverService {

    Page<DriverDTO> findAll(PageRequest pageRequest);

    DriverDTO findById(Long id);

    DriverDTO save(DriverDTO driverDTO);

    DriverDTO update(Long id, DriverDTO driverDTO);

    void delete(Long id);
}
