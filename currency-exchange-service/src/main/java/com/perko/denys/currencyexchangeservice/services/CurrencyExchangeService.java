package com.perko.denys.currencyexchangeservice.services;

import com.perko.denys.currencyexchangeservice.dto.ExchangeValueDto;
import com.perko.denys.currencyexchangeservice.entity.ExchangeValue;

public interface CurrencyExchangeService {

	ExchangeValueDto findRateByFromAndTo(ExchangeValueDto exchangeValueDto);

}
