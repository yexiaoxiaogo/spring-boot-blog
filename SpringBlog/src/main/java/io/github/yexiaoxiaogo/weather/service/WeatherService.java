package io.github.yexiaoxiaogo.weather.service;

import java.util.List;

import io.github.yexiaoxiaogo.weather.domain.Weather;
/*
 * 业务逻辑接口
 */
public interface WeatherService {
	//根据城市名称city查询天气信息
	Weather findWeatherByName(String cityname);
	//根据city查询天气信息列表
	List<Weather> findWeatherListByName(String cityname);
	//插入一条天气信息
	Long insertWeather(Weather weather);
	

}
