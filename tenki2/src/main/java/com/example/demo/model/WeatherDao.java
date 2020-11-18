package com.example.demo.model;

import java.util.Map;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WeatherDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Weather> findBySql(String selectSql) {
		RowMapper<Weather> mapper = new BeanPropertyRpwMapper<Weather>(Weather.class);
		List<Weather> weatherList = jdbcTemplate.query(selectSql, mapper);
		return weatherList;
	}

	public List<Weather> findBySql(String selectSql, Map<String, String> condition) {
		RowMapper<Weather> mapper = new BeanPropertyRowMapper<Weather>(Weather.class);
		List<Weather> weatherList = jdbcTemplate.query(selectSql, condition, mapper);
	}

	public int insert(String insertSql) {
		return insert(insertSql, new Hashmap<String, String>());
	}


}
