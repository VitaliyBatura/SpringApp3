package org.example.model.mapper;

import org.example.model.dto.PersonDto;
import org.example.model.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonDto toPersonDto(Person person);

    Person toPerson(PersonDto personDto);

    List<PersonDto> toPersonDtoList(List<Person> persons);
}