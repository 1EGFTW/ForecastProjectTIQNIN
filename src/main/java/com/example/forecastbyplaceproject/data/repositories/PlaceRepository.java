package com.example.forecastbyplaceproject.data.repositories;

import com.example.forecastbyplaceproject.data.entities.Country;
import com.example.forecastbyplaceproject.data.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place getPlaceByCountryAndPlaceName(Country countryName,String placeName);
}
