package com.fiap.postech.parkingmeter.controllers;

import com.fiap.postech.parkingmeter.dtos.DriverDTO;
import com.fiap.postech.parkingmeter.services.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<Page<DriverDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<DriverDTO> drivers = driverService.findAll(pageRequest);

        return ResponseEntity.ok(drivers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> findById(@PathVariable Long id) {
        var driver = driverService.findById(id);

        return ResponseEntity.ok(driver);
    }

    @PostMapping
    public ResponseEntity<DriverDTO> save(@Valid @RequestBody DriverDTO driverDTO) {
        var driver = driverService.save(driverDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(driver);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> update(@PathVariable Long id, @Valid @RequestBody DriverDTO driverDTO) {
        var driver = driverService.update(id, driverDTO);

        return ResponseEntity.ok(driver);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        driverService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Driver deleted successfully!");
    }
}
