package com.example.forecastbyplaceproject.data.services.weather;

import com.example.forecastbyplaceproject.api.models.weather.WeatherRequest;
import com.example.forecastbyplaceproject.domain.mapper.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.weather.interfaces.ForecastService;
import com.example.forecastbyplaceproject.data.services.weather.interfaces.PlaceService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Primary
public class PlaceServiceImpl implements PlaceService{
    private final PlaceRepository placeRepository;
    private final CountryRepository countryRepository;
    private final ForecastService forecastService;
    private final RequestChecker requestChecker;

    public PlaceServiceImpl(PlaceRepository placeRepository, CountryRepository countryRepository, ForecastService forecastService, RequestChecker requestChecker) {
        this.placeRepository = placeRepository;
        this.countryRepository = countryRepository;
        this.forecastService = forecastService;
        this.requestChecker = requestChecker;
    }

    @Override
    public WeatherResponseMapper getWeatherByLocation(WeatherRequest weatherRequest) {
        return Stream.of(countryRepository.getCountryByCountryName(weatherRequest.getCountry()))
                .filter(Objects::nonNull)
                .map(c->placeRepository.getPlaceByCountryAndPlaceName(c, weatherRequest.getPlace()))
                .filter(Objects::nonNull)
                .map(place -> {
                    Forecast forecast=forecastService.getForecast(place.getLon(),place.getLat());
                    String temp= requestChecker.tempConverter(weatherRequest,forecast);
                    return WeatherResponseMapper.builder()
                            .placeName(place.getPlaceName())
                            .typeName(place.getType().getTypeName())
                            .temp(temp)
                            .countryName(place.getCountry().getCountryName())
                            .build();
                })
                .findAny()
                .orElseThrow();
    }


    @Override
    public List<WeatherResponseMapper> getAllWeather() {
        return  placeRepository.findAll()
                .stream()
                .map(p ->{
                    Forecast forecast=forecastService.getForecast(p.getLon(),p.getLat());
                    return WeatherResponseMapper.builder()
                            .placeName(p.getPlaceName())
                            .typeName(p.getType().getTypeName())
                            .temp(String.valueOf(forecast.getCurrent().getTemp_c()))
                            .countryName(p.getCountry().getCountryName())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
