package com.perko.denys.currencyexchangeservice.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.perko.denys.currencyexchangeservice.entity.ExchangeValue;

@Repository
public class ExchangeValueRepositories {
	
	private List<ExchangeValue> exchangeValueList = new ArrayList<ExchangeValue>();
	
	@PostConstruct
	public void initMethod() {
		exchangeValueList.add(new ExchangeValue(1L, "USD", "INR", new BigDecimal(95)));
		exchangeValueList.add(new ExchangeValue(2L, "UAH", "EUR", new BigDecimal(34)));
		exchangeValueList.add(new ExchangeValue(3L, "UAH", "USD", new BigDecimal(28)));
		exchangeValueList.add(new ExchangeValue(4L, "USD", "INR", new BigDecimal(95)));
	}

	public ExchangeValue findByFromAndTo(String currencyFrom, String currencyTo) {
		return exchangeValueList.stream().filter(exchangeValue -> 
							exchangeValue.getCurrencyFrom().equals(currencyFrom) &&
							exchangeValue.getCurrencyTo().equals(currencyTo)
				            ).findFirst().get();
	}

}
