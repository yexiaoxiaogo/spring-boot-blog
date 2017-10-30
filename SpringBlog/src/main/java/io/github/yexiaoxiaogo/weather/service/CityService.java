package io.github.yexiaoxiaogo.weather.service;

import io.github.yexiaoxiaogo.weather.domain.City;

public interface CityService {

	City findCityNameByCityId(String cityid);
}
