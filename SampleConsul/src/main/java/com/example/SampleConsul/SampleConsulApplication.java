package com.example.SampleConsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class SampleConsulApplication {

	@RequestMapping("/greeting")
	  public String home() {
	    return "Hello World";
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(SampleConsulApplication.class, args);
	}
}
