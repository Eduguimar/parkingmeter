package com.fiap.postech.parkingmeter.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SNSServiceImpl {

    private final SnsClient snsClient;

    public SNSServiceImpl(@Value("${aws.region}") String awsRegion) {
        this.snsClient = SnsClient.builder()
                .region(Region.of(awsRegion))
                .build();
    }

    public void sendNotification(String topicArn, String message) {
        PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(message)
                .build();
        snsClient.publish(request);
    }
}

