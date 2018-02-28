package com.wipro.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoprojectApplication {

	private static Logger logger = Logger.getLogger(DemoprojectApplication.class.getName());

	public static void main(String[] args) {



		SpringApplication.run(DemoprojectApplication.class, args);
	}

}
