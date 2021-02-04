package com.perko.denys.currencyexchangeservice.dto;

import java.math.BigDecimal;

public class ExchangeValueDto {

	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal conversionMultiple;
	
	public ExchangeValueDto() {
	}

	public ExchangeValueDto(String currencyFrom, String currencyTo) {
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
}
