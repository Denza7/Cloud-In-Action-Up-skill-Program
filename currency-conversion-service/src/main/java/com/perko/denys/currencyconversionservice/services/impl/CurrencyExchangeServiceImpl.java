package com.perko.denys.currencyconversionservice.services.impl;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;
import com.perko.denys.currencyconversionservice.entity.CurrencyConversion;
import com.perko.denys.currencyconversionservice.feignclients.CurrencyExchangeClient;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;
import com.perko.denys.currencyconversionservice.services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeClient currencyExchangeClient;

	@Override
	public CurrencyConversionDto retrieveExchangeValue(CurrencyConversionDto currencyConversionDto) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CurrencyConversion response = currencyExchangeClient.retrieveExchangeValue(currencyConversionDto.getCurrencyFrom(), currencyConversionDto.getCurrencyTo());
		currencyConversionDto.setConversionMultiple(response.getConversionMultiple());
		currencyConversionDto.setTotalCalculateAmount(currencyConversionDto.getQuantity().multiply(currencyConversionDto.getConversionMultiple()));
		return currencyConversionDto;
	}

}
