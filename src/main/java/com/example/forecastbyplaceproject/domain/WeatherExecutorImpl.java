package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.services.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.interfaces.WeatherExecutor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class WeatherExecutorImpl implements WeatherExecutor {
    private final PlaceService placeService;

    public WeatherExecutorImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public WeatherResponse execute(WeatherRequest weatherRequest) throws CustomException {
        return placeService.getWeatherByLocation(weatherRequest);
        //tuk trqbva da stava preobrazuvaneto kym weatherResponse
        //paketite trqbva da sa v edinstweno chislo i s malki bukvi
        //da se napr custom exceptions
    }

    @Override
    public List<WeatherResponse> executeAll() {
        return placeService.getAllWeather();
    }
}
