package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.GetService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class GetServiceImpl implements GetService {
    private final PlaceRepository placeRepository;

    public GetServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceGetResponse getPlace(String placeName) throws CustomException {
        Place place=placeRepository.getPlaceByPlaceName(placeName);
        if(place==null){
            throw new CustomException("No such place");
        }

        return PlaceGetResponse.builder()
                .countryName(place.getCountry().getCountryName())
                .lat(place.getLat())
                .lon(place.getLon())
                .typeName(place.getType().getTypeName())
                .placeName(place.getPlaceName())
                .build();
    }

    @Override
    public PlaceGetResponse getPlaceById(Long id) throws CustomException {
        Optional<Place> placeToGET=placeRepository.findById(id);
        Place place=new Place();
        if(placeToGET.isPresent()){
            place=placeToGET.get();
        }
        return PlaceGetResponse.builder()
                .countryName(place.getCountry().getCountryName())
                .lat(place.getLat())
                .lon(place.getLon())
                .typeName(place.getType().getTypeName())
                .placeName(place.getPlaceName())
                .build();

    }
}
