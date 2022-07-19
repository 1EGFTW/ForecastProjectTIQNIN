package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.domain.mapper.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.GetService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GetServiceImpl implements GetService {
    private final PlaceRepository placeRepository;

    public GetServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    @Override
    public PlaceGetResponseMapper getPlaceById(Long id){
       Place place=placeRepository.findById(id).orElseThrow();
        return PlaceGetResponseMapper.builder()
                .countryName(place.getCountry().getCountryName())
                .lat(place.getLat())
                .lon(place.getLon())
                .typeName(place.getType().getTypeName())
                .placeName(place.getPlaceName())
                .build();

    }
}
