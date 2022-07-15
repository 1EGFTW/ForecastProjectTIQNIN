package com.example.forecastbyplaceproject.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "places")
@Getter
@Setter
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeName;
    @ManyToOne
    //@Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @JoinColumn(name="countryId")
    private Country country;

    private Double lat;
    private Double lon;

    @ManyToOne
   // @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @JoinColumn(name="typeId")
    private Type type;


    public Place(String placeName, Country country, Double lat, Double lon, Type type) {
        this.placeName = placeName;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.type = type;
    }
}
