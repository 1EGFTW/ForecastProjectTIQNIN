package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.domain.mapper.PlaceGetResponseMapper;

import java.util.List;

public interface FindService {
    List<PlaceGetResponseMapper> findPlace(String placeName);
}
