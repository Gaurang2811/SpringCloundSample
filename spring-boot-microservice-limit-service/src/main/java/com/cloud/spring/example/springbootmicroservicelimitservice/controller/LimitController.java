package com.cloud.spring.example.springbootmicroservicelimitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.spring.example.springbootmicroservicelimitservice.bean.LimitConfigurationBean;
import com.cloud.spring.example.springbootmicroservicelimitservice.configuration.Configuration;

@RestController
public class LimitController {

	@Autowired
	private Configuration conf;

	@GetMapping("/limits")
	private LimitConfigurationBean getLimits() {
		return new LimitConfigurationBean(conf.getMinimum(), conf.getMaximum());
	}
}
