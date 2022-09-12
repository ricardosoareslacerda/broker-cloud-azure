package br.com.fiap.broker.dronemonitorjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DroneMonitorJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorJobApplication.class, args);
	}
}
