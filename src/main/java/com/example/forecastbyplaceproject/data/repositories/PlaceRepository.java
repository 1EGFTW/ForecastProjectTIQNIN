package com.example.forecastbyplaceproject.data.repositories;

import com.example.forecastbyplaceproject.data.entities.dbentities.Country;
import com.example.forecastbyplaceproject.data.entities.dbentities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place getPlaceByCountryAndPlaceName(Country countryName,String placeName);
    @Query("SELECT p FROM Place p where p.placeName like :name%")
    List<Place> getPlaceByPlaceName(@Param("name") String name); //da se napravi s wildcard
}
