package com.cloud.spring.example.springbootmicroserviceforexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class ForexMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexMicroserviceApplication.class, args);
	}

	@Bean
	// creating a sampler called
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
