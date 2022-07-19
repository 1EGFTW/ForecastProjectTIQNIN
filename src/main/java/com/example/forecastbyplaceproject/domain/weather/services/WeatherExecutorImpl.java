package com.example.forecastbyplaceproject.domain.weather.services;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.weather.WeatherResponse;
import com.example.forecastbyplaceproject.data.services.weather.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.weather.interfaces.WeatherExecutor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Primary
public class WeatherExecutorImpl implements WeatherExecutor {
    private final PlaceService placeService;

    public WeatherExecutorImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public WeatherResponse execute(WeatherRequest weatherRequest){
        return Stream.of(placeService.getWeatherByLocation(weatherRequest))
                .map(weatherResponseMapper -> WeatherResponse.builder()
                        .countryName(weatherResponseMapper.getCountryName())
                        .temp(weatherResponseMapper.getTemp())
                        .typeName(weatherResponseMapper.getTypeName())
                        .placeName(weatherResponseMapper.getPlaceName())
                        .build())
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<WeatherResponse> executeAll() {
        return placeService.getAllWeather()
                .stream()
                .map(w->WeatherResponse.builder()
                        .countryName(w.getCountryName())
                        .temp(w.getTemp())
                        .typeName(w.getTypeName())
                        .placeName(w.getPlaceName())
                        .build())
                .collect(Collectors.toList());
    }
}
