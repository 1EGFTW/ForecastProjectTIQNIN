package com.example.forecastbyplaceproject.domain.weather.services;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.weather.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.mapper.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.services.weather.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.weather.interfaces.WeatherExecutor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        WeatherResponseMapper weatherResponseMapper= placeService.getWeatherByLocation(weatherRequest);
        return WeatherResponse.builder()
                .countryName(weatherResponseMapper.getCountryName())
                .temp(weatherResponseMapper.getTemp())
                .typeName(weatherResponseMapper.getTypeName())
                .placeName(weatherResponseMapper.getPlaceName())
                .build();
        //tuk trqbva da stava preobrazuvaneto kym weatherResponse
        //paketite trqbva da sa v edinstweno chislo i s malki bukvi
        //da se napr custom exceptions
    }

    @Override
    public List<WeatherResponse> executeAll() {
        List<WeatherResponseMapper> weatherResponseMappers= placeService.getAllWeather();
        List<WeatherResponse> result=new ArrayList<>();
        for(WeatherResponseMapper w:weatherResponseMappers){
            result.add(WeatherResponse.builder()
                    .countryName(w.getCountryName())
                    .temp(w.getTemp())
                    .typeName(w.getTypeName())
                    .placeName(w.getPlaceName())
                    .build());
        }
        return result;
    }
}
