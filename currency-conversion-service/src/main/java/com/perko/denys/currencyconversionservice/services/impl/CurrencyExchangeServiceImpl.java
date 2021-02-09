package com.perko.denys.currencyconversionservice.services.impl;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;
import com.perko.denys.currencyconversionservice.entity.CurrencyConversion;
import com.perko.denys.currencyconversionservice.exceptions.CurrencyExchangeException;
import com.perko.denys.currencyconversionservice.feignclients.CurrencyExchangeClient;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;
import com.perko.denys.currencyconversionservice.services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeClient currencyExchangeClient;

	@Override
	public CurrencyConversionDto retrieveExchangeValue(CurrencyConversionDto currencyConversionDto) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		logger.info("Try retrieve exchange value with param: " + "from = " + currencyConversionDto.getCurrencyFrom() + ", to = " + currencyConversionDto.getCurrencyTo());
		try { 
			CurrencyConversion response = currencyExchangeClient.retrieveExchangeValue(currencyConversionDto.getCurrencyFrom(), currencyConversionDto.getCurrencyTo());
			currencyConversionDto.setConversionMultiple(response.getConversionMultiple());
			currencyConversionDto.setTotalCalculateAmount(currencyConversionDto.getQuantity().multiply(currencyConversionDto.getConversionMultiple()));
		} catch (Exception e) {
			throw new CurrencyExchangeException("You entered invalid data");
		}
		return currencyConversionDto;
	}

}
