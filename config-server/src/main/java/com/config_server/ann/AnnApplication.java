package com.config_server.ann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AnnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnApplication.class, args);
	}

}
