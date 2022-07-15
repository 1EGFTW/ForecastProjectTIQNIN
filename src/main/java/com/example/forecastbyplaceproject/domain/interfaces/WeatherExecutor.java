package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;

import java.util.List;

public interface WeatherExecutor {
    WeatherResponse execute(WeatherRequest weatherRequest);
    List<WeatherResponse> executeAll();
}
