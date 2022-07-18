package com.example.forecastbyplaceproject.domain.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

import java.util.List;

public interface PlaceExecutor {
    Long createPlace(PlaceCreateRequest placeCreateRequest);
    void deletePlace(Long id);
    void updatePlace(Long id,PlaceEditRequest placeEditRequest);
    List<PlaceGetResponse> findPlace(String placeName);
    PlaceGetResponse getPlaceById(Long id);
}
