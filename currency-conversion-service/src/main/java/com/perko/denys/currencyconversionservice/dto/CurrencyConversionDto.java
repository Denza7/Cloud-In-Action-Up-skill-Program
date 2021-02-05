package com.perko.denys.currencyconversionservice.dto;

import java.math.BigDecimal;

public class CurrencyConversionDto {

	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal conversionMultiple;
	
	private BigDecimal quantity;
	
	private BigDecimal totalCalculateAmount;
	
	public CurrencyConversionDto() {
	}

	public CurrencyConversionDto(String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
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
