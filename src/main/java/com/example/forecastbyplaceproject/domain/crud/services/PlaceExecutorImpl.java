package com.example.forecastbyplaceproject.domain.crud.services;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.domain.mapper.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.*;
import com.example.forecastbyplaceproject.domain.crud.interfaces.PlaceExecutor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class PlaceExecutorImpl implements PlaceExecutor {
    private final AddService addService;
    private final DeleteService deleteService;
    private final GetService getService;
    private final UpdateService updateService;
    private final FindService findService;

    public PlaceExecutorImpl(AddService addService, DeleteService deleteService, GetService getService, UpdateService updateService, FindService findService) {
        this.addService = addService;
        this.deleteService = deleteService;
        this.getService = getService;
        this.updateService = updateService;
        this.findService = findService;
    }

    @Override
    public Long createPlace(PlaceCreateRequest placeCreateRequest) {
        return addService.add(placeCreateRequest);
    }

    @Override
    public void deletePlace(Long id) {
        deleteService.delete(id);
    }

    @Override
    public void updatePlace(Long id,PlaceEditRequest placeEditRequest){
        updateService.update(id,placeEditRequest);
    }

    @Override
    public List<PlaceGetResponse> findPlace(String placeName){
        return findService.findPlace(placeName)
                .stream()
                .map(p->(PlaceGetResponse.builder()
                        .countryName(p.getCountryName())
                        .lat(p.getLat())
                        .lon(p.getLon())
                        .typeName(p.getTypeName())
                        .placeName(p.getPlaceName())
                        .build()))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceGetResponse getPlaceById(Long id){
        PlaceGetResponseMapper pgrm= getService.getPlaceById(id);
        return PlaceGetResponse.builder()
                .countryName(pgrm.getCountryName())
                .lat(pgrm.getLat())
                .lon(pgrm.getLon())
                .typeName(pgrm.getTypeName())
                .placeName(pgrm.getPlaceName())
                .build();
    }
}
