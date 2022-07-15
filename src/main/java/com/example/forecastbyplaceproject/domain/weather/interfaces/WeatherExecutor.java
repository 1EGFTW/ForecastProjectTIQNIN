package com.example.forecastbyplaceproject.domain.weather.interfaces;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.weather.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

import java.util.List;

public interface WeatherExecutor {
    WeatherResponse execute(WeatherRequest weatherRequest) throws CustomException;
    List<WeatherResponse> executeAll();
}
