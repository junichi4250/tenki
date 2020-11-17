package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.WeatherDao;

@Controller
public class WeatherController {

	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private WeatherLogic weatherLogic;

	@ModelAttribute
	WeatherSearchForm setupForm() {
		return new WeatherSearvhForm();
	}
}
