package com.fiap.postech.parkingmeter.dtos;

public class SummaryExitDTO {

    private Long id;
    private String entryTime;
    private String exitTime;
    private long totalParkingTimeInHours;
    private double totalValue;
    private VehicleDTO vehicleDTO;

    public SummaryExitDTO() {
    }

    public SummaryExitDTO(Long id, String entryTime, String exitTime, long totalParkingTimeInHours, double totalValue, VehicleDTO vehicleDTO) {
        this.id = id;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.totalParkingTimeInHours = totalParkingTimeInHours;
        this.totalValue = totalValue;
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

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public long getTotalParkingTimeInHours() {
        return totalParkingTimeInHours;
    }

    public void setTotalParkingTimeInHours(long totalParkingTimeInHours) {
        this.totalParkingTimeInHours = totalParkingTimeInHours;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
