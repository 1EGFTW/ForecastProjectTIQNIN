package com.example.forecastbyplaceproject.api.controllers;

import com.example.forecastbyplaceproject.api.models.crud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.crud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.exception.CustomException;
import com.example.forecastbyplaceproject.domain.crud.interfaces.PlaceExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {
    private final PlaceExecutor placeExecutor;

    public PlaceController(PlaceExecutor placeExecutor) {
        this.placeExecutor = placeExecutor;
    }

    @PostMapping("/place")
    public String addPlace(@RequestBody PlaceCreateRequest placeCreateRequest){
        return "Id of created place:" + String.valueOf(placeExecutor.createPlace(placeCreateRequest));
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
    public List<PlaceGetResponse> findPlace(@RequestParam String placeName) {
        return  placeExecutor.findPlace(placeName);
    }
    @GetMapping("/place{id}")
    public PlaceGetResponse getPlaceById(@PathVariable Long id){
        return  placeExecutor.getPlaceById(id);
    }
}
