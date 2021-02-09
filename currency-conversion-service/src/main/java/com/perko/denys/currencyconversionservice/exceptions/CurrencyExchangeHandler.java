package com.perko.denys.currencyconversionservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.perko.denys.currencyconversionservice.models.ErrorMessageModel;

@ControllerAdvice
public class CurrencyExchangeHandler {

	@ExceptionHandler(value = CurrencyExchangeException.class)
	public ResponseEntity<Object> handleCurrencyExchangeEcveption(CurrencyExchangeException ex, WebRequest request) {
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}
		ErrorMessageModel errorMessage = new ErrorMessageModel(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
}
