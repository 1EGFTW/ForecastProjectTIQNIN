package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;

public interface UpdateService {
    void update(Long id,PlaceEditRequest placeEditRequest);
}
