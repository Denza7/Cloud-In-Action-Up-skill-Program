package com.perko.denys.exchangeauthenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ExchangeAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeAuthenticationServiceApplication.class, args);
	}

}
