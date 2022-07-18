package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.mapper.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Primary
public class FindServiceImpl implements com.example.forecastbyplaceproject.data.services.crud.interfaces.FindService {
    private final PlaceRepository placeRepository;

    public FindServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceGetResponseMapper> findPlace(String placeName){
        return placeRepository.findAll()
                .stream()
                .filter(Objects::nonNull)
                .filter(place1 -> place1.getPlaceName().equals(placeName))
                .map(p -> PlaceGetResponseMapper.builder()
                .countryName(p.getCountry().getCountryName())
                .lat(p.getLat())
                .lon(p.getLon())
                .typeName(p.getType().getTypeName())
                .placeName(p.getPlaceName())
                .build())
                .collect(Collectors.toList());
    }
}
