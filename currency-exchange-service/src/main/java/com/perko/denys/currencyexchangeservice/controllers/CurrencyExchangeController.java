package com.perko.denys.currencyexchangeservice.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perko.denys.currencyexchangeservice.dto.ExchangeValueDto;
import com.perko.denys.currencyexchangeservice.entity.ExchangeValue;
import com.perko.denys.currencyexchangeservice.model.ExchangeValueModel;
import com.perko.denys.currencyexchangeservice.services.CurrencyExchangeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/form/{from}/to/{to}")
	@ApiOperation(value = "Returns the cost of the required currency for conversion",
	  			response = ExchangeValueModel.class)
	public ResponseEntity<ExchangeValueModel> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ExchangeValueDto result = currencyExchangeService.findRateByFromAndToOrNull(new ExchangeValueDto(from, to));
		if (result == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modelMapper.map(result, ExchangeValueModel.class), HttpStatus.OK);
	}
	
}
