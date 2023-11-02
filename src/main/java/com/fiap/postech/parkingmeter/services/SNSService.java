package com.fiap.postech.parkingmeter.services;

public interface SNSService {

    void sendNotificationToExpiringParking(Long parkingId);
}

