package com.cloud.spring.example.springbootmicroserviceforexservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cloud.spring.example.springbootmicroserviceforexservice.entity.ExchangeValue;
import com.cloud.spring.example.springbootmicroserviceforexservice.repository.ExchangeValueRepository;

@Service
public class ExchangeValueService {

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

//	@Value("${server.port}")
//	String port;

	public ExchangeValue retrieveExchangeValue(String from, String to) {
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		if (null == exchangeValue) {
			exchangeValue = new ExchangeValue();
		}
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
//		exchangeValue.setPort(Integer.parseInt(port));
		return exchangeValue;
	}
}
