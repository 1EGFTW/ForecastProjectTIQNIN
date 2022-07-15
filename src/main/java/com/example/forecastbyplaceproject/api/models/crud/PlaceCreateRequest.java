package com.example.forecastbyplaceproject.api.models.crud;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@EqualsAndHashCode
public class PlaceCreateRequest {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double lat;
    private Double lon;

}
