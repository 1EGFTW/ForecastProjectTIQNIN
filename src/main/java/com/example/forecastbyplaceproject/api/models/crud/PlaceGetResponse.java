package com.example.forecastbyplaceproject.api.models.crud;

import lombok.*;

@Builder
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PlaceGetResponse {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double lat;
    private Double lon;
}
