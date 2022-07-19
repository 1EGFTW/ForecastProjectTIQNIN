package com.example.forecastbyplaceproject.data.services.weather;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.services.weather.interfaces.ForecastService;
import org.springframework.stereotype.Service;

@Service
public class RequestChecker {
    public String tempConverter(WeatherRequest weatherRequest, Forecast forecast){
        boolean flag=weatherRequest.isFahrenheit();
        Double temp_c=forecast.getCurrent().getTemp_c();
        if(flag){
            Double temp_f=(temp_c*1.8)+32;
            return String.valueOf(temp_f);
        }
        return String.valueOf(temp_c);
    }
}
