package com.example.forecastbyplaceproject.api.controllers;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.domain.interfaces.PlaceExecutor;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController {
    private final PlaceExecutor placeExecutor;

    public PlaceController(PlaceExecutor placeExecutor) {
        this.placeExecutor = placeExecutor;
    }

    @PostMapping("/place")
    public void addPlace(@RequestBody PlaceCreateRequest placeCreateRequest){
        placeExecutor.createPlace(placeCreateRequest);
    }
    @DeleteMapping("/place")
    public void deletePlace(@RequestParam Long id){
        placeExecutor.deletePlace(id);
    }
    @PutMapping("/place/{id}")
    public void updatePlace(@RequestBody PlaceEditRequest placeEditRequest,@PathVariable Long id){
        placeExecutor.updatePlace(id,placeEditRequest);
    }
    @GetMapping("/place")
    public PlaceGetResponse getPlace(@RequestParam String placeName) throws CustomException {
        return  placeExecutor.getPlace(placeName);
    }
    //i po id get request
    @GetMapping("/place{id}")
    public PlaceGetResponse getPlaceById(@PathVariable Long id) throws CustomException {
        return  placeExecutor.getPlaceById(id);
    }
}
