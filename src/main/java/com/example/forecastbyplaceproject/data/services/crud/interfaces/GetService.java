package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.domain.mapper.PlaceGetResponseMapper;

public interface GetService {
    PlaceGetResponseMapper getPlaceById(Long id);
}
