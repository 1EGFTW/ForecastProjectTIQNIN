package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.mapper.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.GetService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class GetServiceImpl implements GetService {
    private final PlaceRepository placeRepository;

    public GetServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public   List<PlaceGetResponseMapper> getPlace(String placeName) throws CustomException {
        // Place place=placeRepository.getPlaceByPlaceName(placeName);
        List<Place> places = placeRepository.findAll()
                .stream()
                .filter(place1 -> {
                    return place1.getPlaceName().equals(placeName);
                }).toList();

        if(places==null){
            throw new CustomException("No such place");
        }
        List<PlaceGetResponseMapper> results=new ArrayList<>();
        for(Place p:places){
            results.add(PlaceGetResponseMapper.builder()
                    .countryName(p.getCountry().getCountryName())
                    .lat(p.getLat())
                    .lon(p.getLon())
                    .typeName(p.getType().getTypeName())
                    .placeName(p.getPlaceName())
                    .build());
        }
        return results;
    }

    @Override
    public PlaceGetResponseMapper getPlaceById(Long id) throws CustomException {
        Optional<Place> placeToGET=placeRepository.findById(id);
        Place place=new Place();
        if(placeToGET.isPresent()){
            place=placeToGET.get();
        }
        return PlaceGetResponseMapper.builder()
                .countryName(place.getCountry().getCountryName())
                .lat(place.getLat())
                .lon(place.getLon())
                .typeName(place.getType().getTypeName())
                .placeName(place.getPlaceName())
                .build();

    }
}
