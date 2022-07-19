package com.example.forecastbyplaceproject.domain.mapper;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@EqualsAndHashCode
public class PlaceGetResponseMapper {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double lat;
    private Double lon;
}
