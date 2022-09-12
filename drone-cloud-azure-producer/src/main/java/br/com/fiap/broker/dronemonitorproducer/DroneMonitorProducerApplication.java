package br.com.fiap.broker.dronemonitorproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "br.com.fiap.broker.dronemonitorproducer", "br.com.fiap.broker.dronemonitorproducer.rest" , "br.com.fiap.broker.dronemonitorproducer.config"})
public class DroneMonitorProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorProducerApplication.class, args);
	}
}
