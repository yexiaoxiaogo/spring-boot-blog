package io.github.yexiaoxiaogo.weather.service;

import java.util.List;

import io.github.yexiaoxiaogo.weather.domain.WeatherCity;

public interface WeatherCityService {

	List<WeatherCity> selectAll();
}
