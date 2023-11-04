package com.fiap.postech.parkingmeter.services;

import com.fiap.postech.parkingmeter.models.enums.ParkingType;

public interface SNSService {

    void sendNotification(String phoneNumber, ParkingType parkingType);
}
