package com.example.forecastbyplaceproject.data.services.weather.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.mapper.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

import java.util.List;

public interface PlaceService {
    WeatherResponseMapper getWeatherByLocation(WeatherRequest weatherRequest) throws CustomException;
    List<WeatherResponseMapper> getAllWeather();
}
