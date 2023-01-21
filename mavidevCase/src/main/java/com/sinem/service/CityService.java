package com.sinem.service;

import com.sinem.dto.request.SaveRequestDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ManagerException;
import com.sinem.mapper.ICityMapper;
import com.sinem.repository.ICityRepository;
import com.sinem.repository.entity.City;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService extends ServiceManager<City, Long> {

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        super(cityRepository);
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City saveCity(SaveRequestDto dto) {
        City city = ICityMapper.INSTANCE.toCity(dto);
        if (isExistCityAndDistrict(dto.getCity(), dto.getDistrict())) {
            return cityRepository.save(city);
        } else {
            throw new ManagerException(ErrorType.CITY_NOT_CREATED);
        }
    }
    public Boolean isExistCityAndDistrict(String city,String district) {
        if(cityRepository.findOptionalByCityAndDistrict(city,district).isPresent()) {
            return false;
        } else {
            return true;
        }
    }
    public Optional<City> getById(Long id) {
        return cityRepository.findOptionalById(id);
    }
    public City deleteCity(Long id) {
        Optional<City> city = cityRepository.findOptionalById(id);
        if (city.isPresent()) {
            cityRepository.deleteById(id);
            return city.get();
        } else {
            throw new ManagerException(ErrorType.CITY_NOT_FOUND);
        }
    }
    public Optional<List<City>> getByName(String name) {
        return cityRepository.findOptionalByCityContainingIgnoreCase(name);
    }
}


