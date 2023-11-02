package com.fiap.postech.parkingmeter.dtos;

import com.fiap.postech.parkingmeter.models.enums.ParkingType;

public class SummaryEntryDTO {

    private Long id;
    private String entryTime;
    private ParkingType parkingType;
    private VehicleDTO vehicleDTO;

    public SummaryEntryDTO(){
    }

    public SummaryEntryDTO(Long id, String entryTime, ParkingType parkingType, VehicleDTO vehicleDTO) {
        this.id = id;
        this.entryTime = entryTime;
        this.parkingType = parkingType;
        this.vehicleDTO = vehicleDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
