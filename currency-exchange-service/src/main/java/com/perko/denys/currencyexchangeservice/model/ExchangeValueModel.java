package com.perko.denys.currencyexchangeservice.model;

import java.math.BigDecimal;

public class ExchangeValueModel {

	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal conversionMultiple;
	
	public ExchangeValueModel() {
	}

	public ExchangeValueModel(String currencyFrom, String currencyTo, BigDecimal conversionMultiple) {
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.conversionMultiple = conversionMultiple;
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
