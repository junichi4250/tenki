package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WeatherDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
}
