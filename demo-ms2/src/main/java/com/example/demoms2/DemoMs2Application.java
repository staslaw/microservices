package com.example.demoms2;

import com.example.demoms2.model.Address;
import com.example.demoms2.model.Cinema;
import com.example.demoms2.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMs2Application.class, args);
	}

}
