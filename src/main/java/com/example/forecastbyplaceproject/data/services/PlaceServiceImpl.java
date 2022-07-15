package com.example.forecastbyplaceproject.data.services;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.Country;
import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.interfaces.ForecastService;
import com.example.forecastbyplaceproject.data.services.interfaces.PlaceService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class PlaceServiceImpl implements PlaceService{
    private final PlaceRepository placeRepository;
    private final CountryRepository countryRepository;
    private final ForecastService forecastService;

    public PlaceServiceImpl(PlaceRepository placeRepository, CountryRepository countryRepository, ForecastService forecastService) {
        this.placeRepository = placeRepository;
        this.countryRepository = countryRepository;
        this.forecastService = forecastService;
    }

    @Override
    public WeatherResponse getWeatherByLocation(WeatherRequest weatherRequest) {
        Country country=countryRepository.getCountryByCountryName(weatherRequest.getCountry());
        System.out.println(country);

        if(country==null)
            throw new NullPointerException();

        Place place=placeRepository.getPlaceByCountryAndPlaceName(country, weatherRequest.getPlace());
        System.out.println(place);

        if(place==null)
            throw new NullPointerException();

        Forecast forecast=forecastService.getForecast(place.getLon(),place.getLat());

        return WeatherResponse.builder()
                .placeName(place.getPlaceName())
                .typeName(place.getType().getTypeName())
                .temp(String.valueOf(forecast.getCurrent().getTemp_c()))
                .countryName(place.getCountry().getCountryName())
                .build();
    }

    @Override
    public List<WeatherResponse> getAllWeather() {
        List<WeatherResponse> result=new ArrayList<>();
        for(Place p: placeRepository.findAll()){
            Forecast forecast=forecastService.getForecast(p.getLon(),p.getLat());
            result.add(WeatherResponse.builder()
                    .placeName(p.getPlaceName())
                    .typeName(p.getType().getTypeName())
                    .temp(String.valueOf(forecast.getCurrent().getTemp_c()))
                    .countryName(p.getCountry().getCountryName())
                    .build());
        }
        return result;
    }
}
