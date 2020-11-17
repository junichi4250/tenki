package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.WeatherDao;

@Component
public class WeatherLogic {

	@Autowired
	private WeatherDao weatherDao;


	/** 入力項目チェック */
	public List<String> validateFormForSearch(WeatherSearchForm form) {

	}
}
