package com.perko.denys.currencyexchangeservice.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	private SwaggerConfigProperties swaggerProperties;
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.perko.denys.currencyexchangeservice"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				swaggerProperties.getTitle(),
				swaggerProperties.getDescription(),
				swaggerProperties.getVersion(),
				swaggerProperties.getTermsOfServiceUrl(),
				new Contact(swaggerProperties.getContactName(),
							swaggerProperties.getContactUrl(),
							swaggerProperties.getContactEmail()),
				swaggerProperties.getLicense(),
				swaggerProperties.getLicenseUrl(),
				Collections.emptyList());
	}
	
}
