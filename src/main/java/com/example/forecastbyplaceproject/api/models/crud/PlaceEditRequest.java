package com.example.forecastbyplaceproject.api.models.crud;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@EqualsAndHashCode
public class PlaceEditRequest {
    private String placeName;
}
