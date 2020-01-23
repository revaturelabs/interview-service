package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
/** @see InterviewServiceApplication serves as the MainDriver for the program. */
public class InterviewServiceApplication {

	/** Uses SpringApplication to launch the interview service application.
	 * @param args The command line arguments. */
	public static void main(String[] args) {
		SpringApplication.run(InterviewServiceApplication.class, args);
	}

}
