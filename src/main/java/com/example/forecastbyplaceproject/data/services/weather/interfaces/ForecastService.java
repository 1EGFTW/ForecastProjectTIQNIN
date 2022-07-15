package com.example.forecastbyplaceproject.data.services.weather.interfaces;

import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;

public interface ForecastService {
    Forecast getForecast(Double lon,Double lat);
}
