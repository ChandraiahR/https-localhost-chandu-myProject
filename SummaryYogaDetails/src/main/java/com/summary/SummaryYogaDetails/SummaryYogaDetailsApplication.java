package com.summary.SummaryYogaDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class SummaryYogaDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummaryYogaDetailsApplication.class, args);
	}

	@RequestMapping("/getDetails")
	public String getDetails() {
		RestTemplate restTemplate = new RestTemplate();
		String getDetails = "";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8000/greeting",
				String.class);
		getDetails = responseEntity.getBody();
		return getDetails + "  Response from other micro Services.";
	}
}
