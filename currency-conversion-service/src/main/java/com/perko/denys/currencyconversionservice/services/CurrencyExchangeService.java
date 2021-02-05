package com.perko.denys.currencyconversionservice.services;

import com.perko.denys.currencyconversionservice.dto.CurrencyConversionDto;
import com.perko.denys.currencyconversionservice.models.CurrencyConversionModel;

public interface CurrencyExchangeService {

	CurrencyConversionDto retrieveExchangeValue(CurrencyConversionDto currencyConversionDto);

}
