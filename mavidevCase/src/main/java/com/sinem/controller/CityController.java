package com.sinem.controller;

import com.sinem.dto.request.SaveRequestDto;
import com.sinem.repository.entity.City;
import com.sinem.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sinem.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CITY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CityController {
    private final CityService cityService;

    @PostMapping(CREATE)
    public ResponseEntity<City> create(@RequestBody SaveRequestDto dto) {
        return ResponseEntity.ok(cityService.saveCity(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<City>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }
    @GetMapping(FIND_BY_NAME)
    public ResponseEntity<Optional<List<City>>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(cityService.getByName(name));
    }

 @DeleteMapping(DELETE)
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.deleteCity(id));
    }


}
