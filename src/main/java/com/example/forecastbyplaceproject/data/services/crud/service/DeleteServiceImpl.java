package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.DeleteService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DeleteServiceImpl implements DeleteService {
    private final PlaceRepository placeRepository;

    public DeleteServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}
