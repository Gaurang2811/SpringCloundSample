package com.cloud.spring.example.springbootmicroserviceforexservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.spring.example.springbootmicroserviceforexservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
