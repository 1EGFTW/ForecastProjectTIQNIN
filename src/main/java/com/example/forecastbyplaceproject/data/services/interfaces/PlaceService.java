package com.example.forecastbyplaceproject.data.services.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaceService {
    WeatherResponseMapper getWeatherByLocation(WeatherRequest weatherRequest) throws CustomException;
    List<WeatherResponseMapper> getAllWeather();
}
