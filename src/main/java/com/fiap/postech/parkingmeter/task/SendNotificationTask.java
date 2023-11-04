package com.fiap.postech.parkingmeter.task;

import com.fiap.postech.parkingmeter.models.Parking;
import com.fiap.postech.parkingmeter.repositories.ParkingRepository;
import com.fiap.postech.parkingmeter.services.ParkingService;
import com.fiap.postech.parkingmeter.services.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SendNotificationTask {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    ParkingService parkingService;

    @Autowired
    SNSService snsService;

    @Scheduled(cron = "0 * * * * ?")
    public void executeTask() {
        List<Parking> parkingNotifyList = parkingRepository.findByNextNotificationDateIsLessThanEqual(LocalDateTime.now());
        if (parkingNotifyList.isEmpty()) return;

        for (Parking parking : parkingNotifyList) {
            snsService.sendNotification(parking.getVehicle().getDriver().getPhone(), parking.getParkingType());
            parkingService.updateNextNotificationDate(parking);
        }
    }
}
