package org.example.model.mapper;

import org.example.model.dto.TyreDto;
import org.example.model.entity.Tyre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TyreMapper {

    TyreDto toTyreDto(Tyre tyre);

    @Mapping(target = "vehicles", ignore = true)
    Tyre toTyre(TyreDto tyreDto);

    List<TyreDto> toTyreDtoList(List<Tyre> tyres);

    //List<Tyre> toTyreList(List<TyreDto> tyreDtos);
}