package com.example.forecastbyplaceproject.data.services.interfaces;

import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;

public interface ForecastService {
    Forecast getForecast(Double lon,Double lat);
}
