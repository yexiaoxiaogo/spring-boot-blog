package io.github.yexiaoxiaogo.weather.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

import io.github.yexiaoxiaogo.weather.service.WeatherCityService;

@Component
public class WeatherCityConsumerService {
	@Reference
	public WeatherCityService weatherCityService;

}
