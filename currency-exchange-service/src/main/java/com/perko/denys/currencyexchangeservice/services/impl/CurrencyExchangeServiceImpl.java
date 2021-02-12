package com.perko.denys.currencyexchangeservice.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perko.denys.currencyexchangeservice.dto.ExchangeValueDto;
import com.perko.denys.currencyexchangeservice.entity.ExchangeValue;
import com.perko.denys.currencyexchangeservice.repositories.ExchangeValueRepositories;
import com.perko.denys.currencyexchangeservice.services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private ExchangeValueRepositories exchangeValueRepositories;
	
	@Override
	public ExchangeValueDto findRateByFromAndToOrNull(ExchangeValueDto exchangeValueDto) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Optional<ExchangeValue> exchangeValue = exchangeValueRepositories.findByFromAndTo(exchangeValueDto.getCurrencyFrom(), exchangeValueDto.getCurrencyTo());
		return exchangeValue.isPresent() ? modelMapper.map(exchangeValue.get(), ExchangeValueDto.class) : null;
	}

}
