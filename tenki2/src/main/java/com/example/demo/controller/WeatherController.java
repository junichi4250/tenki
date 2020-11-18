package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/")
	public ModelAndView top() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("top);
	 return modelAndView;

	}

	/**
	 *
	 * 天気の検索を行う
	 */
	＠RequestMapping(value ="weatherSearch/search", method = RequestMethod.POST)
	public ModelAndView ser
}
