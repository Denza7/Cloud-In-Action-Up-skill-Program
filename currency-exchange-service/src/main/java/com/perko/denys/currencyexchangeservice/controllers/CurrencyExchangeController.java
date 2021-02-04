package com.perko.denys.currencyexchangeservice.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.perko.denys.currencyexchangeservice.dto.ExchangeValueDto;
import com.perko.denys.currencyexchangeservice.entity.ExchangeValue;
import com.perko.denys.currencyexchangeservice.model.ExchangeValueModel;
import com.perko.denys.currencyexchangeservice.services.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/form/{from}/to/{to}")
	public ExchangeValueModel retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ExchangeValueDto result = currencyExchangeService.findRateByFromAndTo(new ExchangeValueDto(from, to));
		return modelMapper.map(result, ExchangeValueModel.class);
	}
	
}
