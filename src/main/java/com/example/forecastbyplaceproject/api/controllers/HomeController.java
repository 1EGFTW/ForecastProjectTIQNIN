package com.example.forecastbyplaceproject.api.controllers;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.weather.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.domain.weather.interfaces.WeatherExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final WeatherExecutor weatherExecutor;

    public HomeController(WeatherExecutor weatherExecutor) {
        this.weatherExecutor = weatherExecutor;
    }

    @PostMapping("/getWeather")
    public WeatherResponse getWeather(@RequestBody WeatherRequest weatherRequest) {
        return weatherExecutor.execute(weatherRequest);
    }
    @PostMapping("/getWeathers")
    public List<WeatherResponse> getWeathers(@RequestBody List<WeatherRequest> weatherRequests){
        return weatherExecutor.executeMultiple(weatherRequests);
    }
    @GetMapping("/getAll")
    public List<WeatherResponse> getAll(){
        return weatherExecutor.executeAll();
    }

}
