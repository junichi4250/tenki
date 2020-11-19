package com.example.demo.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.demo.model.WeatherDao;

@Component
public class WeatherLogic {

	@Autowired
	private WeatherDao weatherDao;


	/** 入力項目チェック */
	public List<String> validateFormForSearch(WeatherSearchForm form) {

	}
	
	public String createSqlForSearch(WeatherSearchForm form) {
		boolean isFirstCondition = true;
		StringBuilder selectSql = new StringBuilder("SELECT * FROM WEATHER");
		if (!StringUtils.isEmpty(form.getWeatherDate())) {
			selectSql.append(" WHERE WEATHER_DATE = :weatherDate");
			isFirstCondition = false;
		} 
		if (!StringUtils.isEmpty(form.getPlace())) {
			if (isFirstCondition) {
				selectSql.append(" WHERE PLACE = :place");
				isFirstCondition = false;
			} else {
				selectSql.append(" and PLACE = :place");
			}
		}
		return selectSql.toString();
	}
	
	/**
	 * 検索に使用する条件を作成する
	 * @param form
	 * @return
	 */
	public Map<String, String> createConditionForSearch(WeatherSearchForm form) {
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("weatherDate", form.getWeatherDate());
	    condition.put("place", form.getPlace());
        condition.put("weather", form.getWeather());
	    condition.put("maxTemperature", form.getMaxTemperature());
	    condition.put("minTemperature", form.getMinTemperature());
	    
	    return condition;
	}
}
