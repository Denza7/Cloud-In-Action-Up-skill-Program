package com.perko.denys.currencyconversionservice.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.perko.denys.currencyconversionservice"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				environment.getProperty("swagger.info.title"),
				environment.getProperty("swagger.info.description"),
				environment.getProperty("swagger.info.version"),
				environment.getProperty("swagger.info.termsOfServiceUrl"),
				new Contact(environment.getProperty("swagger.info.contact.name"),
							environment.getProperty("swagger.info.contact.url"),
							environment.getProperty("swagger.info.contact.email")),
				environment.getProperty("swagger.info.license"),
				environment.getProperty("swagger.info.licenseUrl"),
				Collections.emptyList());
	}

}
