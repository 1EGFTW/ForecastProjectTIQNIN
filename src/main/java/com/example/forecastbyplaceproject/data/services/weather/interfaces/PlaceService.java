package com.example.forecastbyplaceproject.data.services.weather.interfaces;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.domain.mapper.WeatherResponseMapper;

import java.util.List;

public interface PlaceService {
    WeatherResponseMapper getWeatherByLocation(WeatherRequest weatherRequest);
    List<WeatherResponseMapper> getAllWeather();
}
