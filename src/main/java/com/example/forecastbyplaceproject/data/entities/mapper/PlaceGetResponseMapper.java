package com.example.forecastbyplaceproject.data.entities.mapper;

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
