package com.perko.denys.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;
import com.perko.denys.currencyconversionservice.services.CurrencyExchangeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("currency-converter")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	@ApiOperation(value = "Converts and returns input data and conversion result",
				  response = CurrencyConversionModel.class)
	public CurrencyConversionModel convertCurrency(@PathVariable String from,
												   @PathVariable String to,
												   @PathVariable BigDecimal quantity) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CurrencyConversionDto response = currencyExchangeService.retrieveExchangeValue(new CurrencyConversionDto(from, to, null, quantity, null));
		return modelMapper.map(response, CurrencyConversionModel.class);
	}
	
}
