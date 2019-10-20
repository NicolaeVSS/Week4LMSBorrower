package com.ss.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LmsWk3Application {

	public static void main(String[] args) {
		System.out.println("it wi");
		SpringApplication.run(LmsWk3Application.class, args);
		
	}

}
