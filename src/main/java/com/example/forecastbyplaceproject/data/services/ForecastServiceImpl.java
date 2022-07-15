package com.example.forecastbyplaceproject.data.services;

import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.restTemplate.interfaces.RestTemplateProvider;
import com.example.forecastbyplaceproject.data.services.interfaces.ForecastService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ForecastServiceImpl implements ForecastService {
    private final RestTemplateProvider restTemplateProvider;

    public ForecastServiceImpl(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    @Override
    public Forecast getForecast(Double lon, Double lat) {
        final String key = "c782585acdc84252b3790106220807";

        final String uri = "http://api.weatherapi.com/v1/current.json?key=" + key + "&q=" + lat
                + "," + lon;

        RestTemplate restTemplate=restTemplateProvider.getTemplate();
        return restTemplate.getForObject(uri, Forecast.class);
    }
}

