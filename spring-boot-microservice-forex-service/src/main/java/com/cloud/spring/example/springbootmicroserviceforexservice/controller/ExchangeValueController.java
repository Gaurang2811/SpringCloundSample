package com.cloud.spring.example.springbootmicroserviceforexservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.spring.example.springbootmicroserviceforexservice.entity.ExchangeValue;
import com.cloud.spring.example.springbootmicroserviceforexservice.service.ExchangeValueService;

@RestController
public class ExchangeValueController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeValueService exchangeValueService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info("called ExchangeValueController.ExchangeValue from -> {}, to -> {}", from, to);
		return exchangeValueService.retrieveExchangeValue(from, to);
	}

}
