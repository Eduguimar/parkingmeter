package com.fiap.postech.parkingmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParkingmeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingmeterApplication.class, args);
	}

}
