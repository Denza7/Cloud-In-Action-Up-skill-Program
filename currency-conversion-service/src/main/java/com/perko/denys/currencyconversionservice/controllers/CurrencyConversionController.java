package com.perko.denys.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;
import com.perko.denys.currencyconversionservice.services.CurrencyExchangeService;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionModel convertCurrency(@PathVariable String from,
												  @PathVariable String to,
												  @PathVariable BigDecimal quantity) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CurrencyConversionDto response = currencyExchangeService.retrieveExchangeValue(new CurrencyConversionDto(from, to, null, quantity, null));
		return modelMapper.map(response, CurrencyConversionModel.class);
	}
	
}
