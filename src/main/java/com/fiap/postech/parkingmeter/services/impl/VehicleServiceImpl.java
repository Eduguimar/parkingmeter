package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.models.Vehicle;
import com.fiap.postech.parkingmeter.repositories.DriverRepository;
import com.fiap.postech.parkingmeter.repositories.VehicleRepository;
import com.fiap.postech.parkingmeter.services.VehicleService;
import com.fiap.postech.parkingmeter.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    DriverRepository driverRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<VehicleDTO> findAll(PageRequest pageRequest) {
        Page<Vehicle> vehicles = vehicleRepository.findAll(pageRequest);
        return vehicles.map(VehicleDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleDTO findById(Long id) {
        var vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Vehicle not found"));
        return new VehicleDTO(vehicle);
    }

    @Override
    @Transactional
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        mapperDtoToEntity(vehicleDTO, vehicle);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return new VehicleDTO(savedVehicle);
    }

    @Override
    @Transactional
    public VehicleDTO update(Long id, VehicleDTO vehicleDTO) {
        try {
            Vehicle vehicle = vehicleRepository.getOne(id);
            mapperDtoToEntity(vehicleDTO, vehicle);
            return new VehicleDTO(vehicleRepository.save(vehicle));
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Vehicle not found, id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            vehicleRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Vehicle not found, id: " + id);
        }
    }

    private void mapperDtoToEntity(VehicleDTO dto, Vehicle vehicle) {
        vehicle.setModel(dto.getModel());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setYear(dto.getYear());
        vehicle.setParkedPerHour(dto.isParkedPerHour());
        vehicle.setDriver(driverRepository.getOne(dto.getDriverDTO().getId()));
    }
}
