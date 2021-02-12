package com.perko.denys.currencyexchangeservice.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class ExchangeValueModel {

	@ApiModelProperty(notes = "Currency conversion from", example = "USD")
	private String currencyFrom;
	
	@ApiModelProperty(notes = "Currency conversion to", example = "INR")
	private String currencyTo;
	
	@ApiModelProperty(notes = "Rate", example = "55")
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
