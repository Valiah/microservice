package com.example.discoveru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveruApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveruApplication.class, args);
	}

}
