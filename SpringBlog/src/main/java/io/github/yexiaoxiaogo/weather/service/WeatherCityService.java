package io.github.yexiaoxiaogo.weather.service;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;

import io.github.yexiaoxiaogo.weather.domain.WeatherCity;

public interface WeatherCityService {

	@Reference
	List<WeatherCity> selectAll();
}
