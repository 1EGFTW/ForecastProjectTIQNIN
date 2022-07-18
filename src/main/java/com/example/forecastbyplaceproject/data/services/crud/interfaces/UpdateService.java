package com.example.forecastbyplaceproject.data.services.crud.interfaces;

import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;

public interface UpdateService {
    void update(Long id,PlaceEditRequest placeEditRequest);
}
