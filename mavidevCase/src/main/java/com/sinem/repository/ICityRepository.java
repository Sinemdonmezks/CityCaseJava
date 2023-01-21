package com.sinem.repository;

import com.sinem.repository.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {


    Optional<City> findOptionalByCityAndDistrict(String city, String district);
    Optional<City> findOptionalById(Long id);

    Optional<List<City>> findOptionalByCityContainingIgnoreCase(String name);
}
