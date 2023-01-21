package com.sinem.utility;


import com.sinem.repository.entity.City;
import com.sinem.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DefaultDataImpl {
private final CityService cityService;
    @PostConstruct
    private  void create(){
        saveImplToDatabase();
    }

    private void saveImplToDatabase() {
        City city1 = City.builder()
                .city("New York")
                .district("Manhattan")
                .build();
        cityService.save(city1);
        City city2 = City.builder()
                .city("Bursa")
                .district("Nilüfer")
                .build();
        cityService.save(city2);
        City city3 = City.builder()
                .city("Ankara")
                .district("Çankaya")
                .build();
        cityService.save(city3);
        City city4 = City.builder()
                .city("Edinburgh")
                .district("Eglington")
                .build();
        cityService.save(city4);
        City city5 = City.builder()
                .city("Los Angeles")
                .district("Hollywood")
                .build();
        cityService.save(city5);
        City city6 = City.builder()
                .city("London")
                .district("Westminster")
                .build();
        cityService.save(city6);

    }

}
