package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.mapper.PlaceGetResponseMapper;

import java.util.List;

public interface GetService {
    List<PlaceGetResponseMapper> getPlace(String placeName) throws CustomException;
    PlaceGetResponseMapper getPlaceById(Long id) throws CustomException;
}
