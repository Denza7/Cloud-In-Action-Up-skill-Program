package com.perko.denys.currencyconversionservice.models;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class CurrencyConversionModel {
	
	@ApiModelProperty(notes = "Currency conversion from", example = "USD")
	private String currencyFrom;
	
	@ApiModelProperty(notes = "Currency conversion to", example = "INR")
	private String currencyTo;
	
	@ApiModelProperty(notes = "Rate", example = "55")
	private BigDecimal conversionMultiple;
	
	@ApiModelProperty(notes = "Amount of money to be converted", example = "100")
	private BigDecimal quantity;
	
	@ApiModelProperty(notes = "Conversion result", example = "5500")
	private BigDecimal totalCalculateAmount;
	
	public CurrencyConversionModel() {
	}

	public CurrencyConversionModel(String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculateAmount) {
		this.currencyFrom = from;
		this.currencyTo = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculateAmount = totalCalculateAmount;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String from) {
		this.currencyFrom = from;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String to) {
		this.currencyTo = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculateAmount() {
		return totalCalculateAmount;
	}

	public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
		this.totalCalculateAmount = totalCalculateAmount;
	}
	
}
