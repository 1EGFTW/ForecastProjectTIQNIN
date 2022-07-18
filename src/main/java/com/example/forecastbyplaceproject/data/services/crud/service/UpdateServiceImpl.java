package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.UpdateService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class UpdateServiceImpl implements UpdateService {
    private final PlaceRepository placeRepository;

    public UpdateServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void update(Long id,PlaceEditRequest placeEditRequest) {
        Place placeToUpdate=placeRepository.findById(id).orElseThrow();
        placeToUpdate.setPlaceName(placeEditRequest.getPlaceName());
        placeRepository.save(placeToUpdate);
    }
}
