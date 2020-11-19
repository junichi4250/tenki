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
		return new WeatherSearchForm();
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
	public ModelAndView search(@Valideted WeatherSearchForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		  // 項目精査を行う
        List<String> errorList = weatherLogic.validateFormForSearch(form);
        if (!errorList.isEmpty()) {
            modelAndView.addObject("errorList", errorList);
            modelAndView.addObject("form", form);
            modelAndView.setViewName("weatherSearch");
            return modelAndView;
        }

        String selectSql = weatherLogic.createSqlForSearch(form);
        Map<String, String> condition = weatherLogic.createConditionForSearch(form);
        List<Weather> weatherList = weatherDao.findBySql(selectSql, condition);

        if (weatherList.isEmpty()) {
        	errorList.add("検索結果がありません");
        	modelAndView.addObject("errorList", errorList);
        	modelAndView.addObject("form", form);
        	modelAndView.setViewName("weatherSearch");
        }

        modelAndView.addObject("form", form);
        modelAndView.addObject("weatherList", weatherList);
        modelAndView.setViewName("weatherSearch");
        return modelAndView;
	}

	/**
	 * 天気の検索を行う（発展編）
	 */
	@RequestMapping(value = "weatherSearchHard/search", method = RequestMethod.POST)
	public ModelandView searchHard(@Validated WeatherSearchForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelandView();

		//項目精査を行う
		List<String> errorList = weatherLogic.validateFormForSearchHard(form);
		if(!errorList.isEmpty()) {
			modelAndView.addObject("errorList", errorList);
			modelAndView.addObject("form", form);
			modelAndView.setViewName("weatherSearchHard");
			return modelAndView;
		}

		errorList = weatherLogic.validateBetweenItemForSearchHard(form);
        if (!errorList.isEmpty()) {
            modelAndView.addObject("errorList", errorList);
            modelAndView.addObject("form", form);
            modelAndView.setViewName("weatherSearchHard");
            return modelAndView;
        }

        String selectSql = weatherLogic.createSqlForSearchHard(form);
        Map<String, String> condition = weatherLogic.createConditionForSearchHard(form);
        List<Weather> weatherList = weatherDao.findBySql(selectSql, condition);

        String selectSql = weatherLogic.createSqlForSearchHard(form);
        Map<String, String> condition = weatherLogic.createConditionForSearchHard(form);
        List<Weather> weatherList = weatherDao.findBySql(selectSql, condition);

        modelAndView.addObject("form", form);
        modelAndView.addObject("weatherList", weatherList);
        modelAndView.addObject("searchCount", weatherList.size());
        if (weatherList.isEmpty()) {
            modelAndView.addObject("noResult", Boolean.TRUE);
        }
        modelAndView.setViewName("weatherSearchHard");
        return modelAndView;
	}
}
