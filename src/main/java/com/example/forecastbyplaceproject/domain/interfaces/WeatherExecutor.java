package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

import java.util.List;

public interface WeatherExecutor {
    WeatherResponse execute(WeatherRequest weatherRequest) throws CustomException;
    List<WeatherResponse> executeAll();
}
