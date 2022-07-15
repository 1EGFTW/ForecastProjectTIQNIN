package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;

public interface AddService {
    Long add(PlaceCreateRequest createRequest);
}
