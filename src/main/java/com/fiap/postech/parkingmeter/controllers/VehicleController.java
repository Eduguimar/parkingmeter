package com.fiap.postech.parkingmeter.controllers;

import com.fiap.postech.parkingmeter.dtos.VehicleDTO;
import com.fiap.postech.parkingmeter.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<VehicleDTO> vehicles = vehicleService.findAll(pageRequest);

        return ResponseEntity.ok(vehicles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable Long id) {
        var vehicle = vehicleService.findById(id);

        return ResponseEntity.ok(vehicle);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> save(@Valid @RequestBody VehicleDTO vehicleDTO) {
        var vehicle = vehicleService.save(vehicleDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Long id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        var vehicle = vehicleService.update(id, vehicleDTO);

        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        vehicleService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Vehicle deleted successfully!");
    }
}
