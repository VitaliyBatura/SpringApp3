package org.example.model.mapper;

import org.example.model.dto.TyreDto;
import org.example.model.entity.Tyre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TyreMapper {

    TyreDto toTyreDto(Tyre tyre);

    Tyre toTyre(TyreDto tyreDto);

    List<TyreDto> toTyreDtoList(List<Tyre> tyres);
}