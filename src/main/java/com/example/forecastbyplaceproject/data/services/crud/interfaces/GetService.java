package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

public interface GetService {
    PlaceGetResponse getPlace(String placeName) throws CustomException;
    PlaceGetResponse getPlaceById(Long id) throws CustomException;
}
