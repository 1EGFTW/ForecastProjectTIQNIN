package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.data.entities.mapper.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.AddService;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.DeleteService;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.GetService;
import com.example.forecastbyplaceproject.data.services.crud.interfaces.UpdateService;
import com.example.forecastbyplaceproject.domain.interfaces.PlaceExecutor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class PlaceExecutorImpl implements PlaceExecutor {
    private final AddService addService;
    private final DeleteService deleteService;
    private final GetService getService;
    private final UpdateService updateService;

    public PlaceExecutorImpl(AddService addService, DeleteService deleteService, GetService getService, UpdateService updateService) {
        this.addService = addService;
        this.deleteService = deleteService;
        this.getService = getService;
        this.updateService = updateService;
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
    public void updatePlace(Long id,PlaceEditRequest placeEditRequest) {
        updateService.update(id,placeEditRequest);
    }

    @Override
    public List<PlaceGetResponse> getPlace(String placeName) throws CustomException {
        List<PlaceGetResponseMapper> rgrm=getService.getPlace(placeName);
        List<PlaceGetResponse> results=new ArrayList<>();
        for(PlaceGetResponseMapper p:rgrm){
            results.add(PlaceGetResponse.builder()
                    .countryName(p.getCountryName())
                    .lat(p.getLat())
                    .lon(p.getLon())
                    .typeName(p.getTypeName())
                    .placeName(p.getPlaceName())
                    .build());
        }
        return results;
    }

    @Override
    public PlaceGetResponse getPlaceById(Long id) throws CustomException {
        PlaceGetResponseMapper rgrm= getService.getPlaceById(id);
        return PlaceGetResponse.builder()
                .countryName(rgrm.getCountryName())
                .lat(rgrm.getLat())
                .lon(rgrm.getLon())
                .typeName(rgrm.getTypeName())
                .placeName(rgrm.getPlaceName())
                .build();
    }
}
