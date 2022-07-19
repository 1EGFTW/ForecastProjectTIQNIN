package com.example.forecastbyplaceproject.domain.mapper;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WeatherResponseMapper {
    private String placeName;
    private String typeName;
    private String countryName;
    private String temp;
}
