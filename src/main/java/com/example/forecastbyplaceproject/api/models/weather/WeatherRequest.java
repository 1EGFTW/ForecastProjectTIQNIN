package com.example.forecastbyplaceproject.api.models.weather;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class WeatherRequest {
    private String place;
    private String country;
}
