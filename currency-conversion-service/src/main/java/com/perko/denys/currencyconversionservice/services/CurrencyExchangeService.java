package com.perko.denys.currencyconversionservice.services;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;

public interface CurrencyExchangeService {

	CurrencyConversionDto retrieveExchangeValue(CurrencyConversionDto currencyConversionDto);
	
}
