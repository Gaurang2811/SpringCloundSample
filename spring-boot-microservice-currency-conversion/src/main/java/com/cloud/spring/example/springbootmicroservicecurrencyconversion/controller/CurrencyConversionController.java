package com.cloud.spring.example.springbootmicroservicecurrencyconversion.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.spring.example.springbootmicroservicecurrencyconversion.bean.CurrencyConversionBean;
import com.cloud.spring.example.springbootmicroservicecurrencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyConversionService currencyConversionService;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("called CurrencyConversionController.convertCurrency from -> {}, to -> {}, quantity -> {} ", from,
				to, quantity);
		return currencyConversionService.convertCurrencyUsingProxy(from, to, quantity);
	}
}
