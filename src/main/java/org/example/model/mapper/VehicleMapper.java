package org.example.model.mapper;

import org.example.model.dto.VehicleDto;
import org.example.model.dto.VehicleShortDto;
import org.example.model.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface VehicleMapper {

    VehicleDto toVehicleDto(Vehicle vehicle);

    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "person.id", source = "person")
    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleShortDto toVehicleShortDto(Vehicle vehicle);

    List<VehicleShortDto> toVehicleDtoList(List<Vehicle> vehicles);

    List<Vehicle> toVehicleList(List<VehicleDto> vehicleDtos);
}
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "publishingHouse.id", source = "publishingHouse")
//    @Mapping(target = "authors", expression = "java(toAuthorsFromAuthorIds(newBookDto.getAuthors()))")
//    Book toBook(NewBookDto newBookDto);
//
//    BookShort toBookShort(Book book);
//
//    Set<BookShort> toBookShortSet(Set<Book> books);
//
//    BookDto toBookDto(Book book);
//
//    default Set<Author> toAuthorsFromAuthorIds(Set<Long> authorIds) {
//        Set<Author> authors = new LinkedHashSet<>();
//        for (Long authorId : authorIds) {
//            Author author = new Author();
//            author.setId(authorId);
//            authors.add(author);
//        }
//        return authors;
//    }
