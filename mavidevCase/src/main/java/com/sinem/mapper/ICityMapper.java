package com.sinem.mapper;


import com.sinem.dto.request.SaveRequestDto;
import com.sinem.repository.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICityMapper {
    ICityMapper INSTANCE = Mappers.getMapper(ICityMapper.class);

    City toCity(SaveRequestDto dto);
}