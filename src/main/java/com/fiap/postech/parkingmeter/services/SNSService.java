package com.fiap.postech.parkingmeter.services;

public interface SNSService {

    void sendNotification(String topicArn, String message);
}

