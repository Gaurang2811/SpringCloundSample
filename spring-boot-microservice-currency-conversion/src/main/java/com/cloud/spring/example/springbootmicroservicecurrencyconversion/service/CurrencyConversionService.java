package com.cloud.spring.example.springbootmicroservicecurrencyconversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloud.spring.example.springbootmicroservicecurrencyconversion.bean.CurrencyConversionBean;
import com.cloud.spring.example.springbootmicroservicecurrencyconversion.service.proxy.CurrencyExchangeServiceProxy;

@Service
public class CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	public CurrencyConversionBean convertCurrencyUsingProxy(String from, String to, BigDecimal quantity) {

		CurrencyConversionBean bean = currencyExchangeServiceProxy.retriveExchangeValue(from, to);

		if (null == bean) {
			bean = new CurrencyConversionBean();
		} else {
			bean.setQuantity(quantity);
			bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		}
		return bean;
	}

	/**
	 * We are not using this method as we need to mention the restClient and
	 * complete URL.
	 * 
	 * @param from
	 * @param to
	 * @param quantity
	 * @return
	 */
	public CurrencyConversionBean convertCurrency(String from, String to, BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> response = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean bean = response.getBody();
		if (null == bean) {
			bean = new CurrencyConversionBean();
		} else {
			bean.setQuantity(quantity);
			bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		}
		return bean;
	}
}
