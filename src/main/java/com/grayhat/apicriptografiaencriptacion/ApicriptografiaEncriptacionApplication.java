package com.grayhat.apicriptografiaencriptacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApicriptografiaEncriptacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicriptografiaEncriptacionApplication.class, args);
	}

}
