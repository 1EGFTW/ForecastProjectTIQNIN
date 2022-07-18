package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.mapper.PlaceGetResponseMapper;

import java.util.List;

public interface FindService {
    List<PlaceGetResponseMapper> findPlace(String placeName);
}
