package com.cloud.spring.example.springbootmicroserviceforexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.spring.example.springbootmicroserviceforexservice.entity.ExchangeValue;
import com.cloud.spring.example.springbootmicroserviceforexservice.service.ExchangeValueService;

@RestController
public class ExchangeValueController {

	@Autowired
	private ExchangeValueService exchangeValueService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return exchangeValueService.retrieveExchangeValue(from, to);
	}

}
