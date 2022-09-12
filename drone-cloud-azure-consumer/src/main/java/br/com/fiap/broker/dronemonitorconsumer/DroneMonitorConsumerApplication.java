package br.com.fiap.broker.dronemonitorconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.broker.dronemonitorconsumer.config",
		"br.com.fiap.broker.dronemonitorconsumer.business",
		"br.com.fiap.broker.dronemonitorconsumer.consumer",
		"br.com.fiap.broker.dronemonitorconsumer.service"})
@EntityScan("br.com.fiap.broker.dronemonitorconsumer.model")
@EnableMongoRepositories("br.com.fiap.broker.dronemonitorconsumer.repository")
@EnableAutoConfiguration
public class DroneMonitorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorConsumerApplication.class, args);
	}

}

