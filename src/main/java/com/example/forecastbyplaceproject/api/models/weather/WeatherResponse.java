package com.example.forecastbyplaceproject.api.models.weather;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WeatherResponse {
    private String placeName;
    private String typeName;
    private String countryName;
    private String temp;
}
