package com.example.server.MicroServicesWithSpringBootServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroServicesWithSpringBootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootServerApplication.class, args);
		System.out.println("Server has started...........");
	}
}
