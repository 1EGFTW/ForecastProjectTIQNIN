package com.example.forecastbyplaceproject.api.models.crud;

import lombok.*;

@Builder
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PlaceEditRequest {
    private String placeName;
}
