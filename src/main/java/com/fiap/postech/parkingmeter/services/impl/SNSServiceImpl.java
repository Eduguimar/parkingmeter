package com.fiap.postech.parkingmeter.services.impl;

import com.fiap.postech.parkingmeter.models.enums.ParkingType;
import com.fiap.postech.parkingmeter.repositories.ParkingRepository;
import com.fiap.postech.parkingmeter.services.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SNSServiceImpl implements SNSService {

    @Autowired
    ParkingRepository parkingRepository;

    private final SnsClient snsClient;

    public SNSServiceImpl(@Value("${aws.region}") String awsRegion) {
        this.snsClient = SnsClient.builder()
                .region(Region.of(awsRegion))
                .build();
    }

    public void sendNotification(String phoneNumber, ParkingType parkingType) {
        String message;

        if (parkingType.equals(ParkingType.FIXED_PERIOD)) {
            message = "Olá, ParkingMeter informa que seu horário se esgotará em 10 minutos.";
        } else {
            message = "Olá, ParkingMeter informa que em 10 minutos será cobrado mais uma hora de estacionamento.";
        }

        PublishRequest request = PublishRequest.builder()
                .phoneNumber(phoneNumber)
                .topicArn("parkingmeter-notification-arn") //implementação não conectada
                .message(message)
                .build();

        snsClient.publish(request);
    }
}
