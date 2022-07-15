package com.example.forecastbyplaceproject.data.entities.dbentities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;
    private String countryName;
    @OneToMany(mappedBy = "country")
   // @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Place> places=new HashSet<>();

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }


}
