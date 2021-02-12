package com.perko.denys.currencyconversionservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.perko.denys.currencyconversionservice.entity.CurrencyConversion;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeClient {

	@GetMapping("/currency-exchange/form/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
