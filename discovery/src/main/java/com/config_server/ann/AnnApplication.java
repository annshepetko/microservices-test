package com.config_server.ann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnApplication.class, args);
	}

}
