package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

public interface PlaceExecutor {
    Long createPlace(PlaceCreateRequest placeCreateRequest);
    void deletePlace(Long id);
    void updatePlace(Long id,PlaceEditRequest placeEditRequest);
    PlaceGetResponse getPlace(String placeName) throws CustomException;
    PlaceGetResponse getPlaceById(Long id) throws CustomException;
}
