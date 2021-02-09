package com.perko.denys.currencyconversionservice.entity;

import java.math.BigDecimal;

public class CurrencyConversion {

private Long id;
	
	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal conversionMultiple;
	
	private BigDecimal quantity;
	
	private BigDecimal totalCalculateAmount;
	
	public CurrencyConversion() {
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculateAmount) {
		this.id = id;
		this.currencyFrom = from;
		this.currencyTo = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculateAmount = totalCalculateAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String from) {
		this.currencyFrom = from;
	}

	public String geCurrencytTo() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyConversion other = (CurrencyConversion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
