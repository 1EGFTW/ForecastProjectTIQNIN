package com.example.forecastbyplaceproject.data.repositories;

import com.example.forecastbyplaceproject.data.entities.dbentities.Country;
import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place getPlaceByCountryAndPlaceName(Country countryName,String placeName);
    Place getPlaceByPlaceName(String name);
}
