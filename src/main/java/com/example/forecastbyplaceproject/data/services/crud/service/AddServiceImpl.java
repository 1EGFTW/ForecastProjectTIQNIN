package com.example.forecastbyplaceproject.data.services.crud.service;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.data.entities.dbentities.Country;
import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import com.example.forecastbyplaceproject.data.entities.dbentities.Type;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.repositories.TypeRepository;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.AddService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AddServiceImpl implements AddService {
    private final PlaceRepository placeRepository;
    private final TypeRepository typeRepository;
    private final CountryRepository countryRepository;

    public AddServiceImpl(PlaceRepository placeRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
        this.placeRepository = placeRepository;
        this.typeRepository = typeRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Long add(PlaceCreateRequest createRequest) {
        if(typeRepository.getByTypeName(createRequest.getTypeName())==null){
            Type typeToAdd=new Type(createRequest.getTypeName());
            typeRepository.save(typeToAdd);
        }
        Type type=typeRepository.getByTypeName(createRequest.getTypeName());

        if(countryRepository.getCountryByCountryName(createRequest.getCountryName())==null){
            Country countryToAdd=new Country(createRequest.getCountryName());
            countryRepository.save(countryToAdd);
        }
        Country country=countryRepository.getCountryByCountryName(createRequest.getCountryName());

        Place place=new Place(createRequest.getPlaceName(), country, createRequest.getLat(), createRequest.getLon(), type);
        placeRepository.save(place);

        place=placeRepository.getPlaceByPlaceName(place.getPlaceName());

        return place.getId();
    }
}
