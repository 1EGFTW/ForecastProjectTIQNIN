package com.example.forecastbyplaceproject.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "placeTypes")
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String typeName;

    @OneToMany(mappedBy = "type")
   // @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Place> places=new HashSet<>();

    public Type(String typeName) {
        this.typeName = typeName;
    }
}
