package com.example.forecastbyplaceproject.data.repositories;

import com.example.forecastbyplaceproject.data.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type getByTypeName(String name);
}
