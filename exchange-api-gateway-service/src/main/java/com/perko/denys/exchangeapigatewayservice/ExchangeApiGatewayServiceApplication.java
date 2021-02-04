package com.perko.denys.exchangeapigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ExchangeApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApiGatewayServiceApplication.class, args);
	}

}
