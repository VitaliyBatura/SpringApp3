package org.example.controller;

import org.example.model.dto.TyreDto;
import org.example.model.entity.Tyre;
import org.example.model.mapper.TyreMapper;
import org.example.service.TyreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class TyreController {

    private TyreService tyreService;
    private TyreMapper tyreMapper;

    public TyreController(TyreService tyreService, TyreMapper tyreMapper) {
        this.tyreService = tyreService;
        this.tyreMapper = tyreMapper;
    }

    @PostMapping("/tyres")
    public TyreDto createTyre(@RequestBody TyreDto tyreDto) {
        Tyre tyre = tyreMapper.toTyre(tyreDto);
        return tyreMapper.toTyreDto(tyreService.create(tyre));
    }

    @GetMapping("/tyres/{id}")
    public TyreDto readOneTyre(@PathVariable Long id) {
        return tyreMapper.toTyreDto(tyreService.readById(id));
    }

    @GetMapping("/tyres")
    public List<TyreDto> readAllTyres() {
        return tyreMapper.toTyreDtoList(tyreService.readAll());
    }

    @PutMapping("/tyres/{id}")
    public TyreDto updateTyre(@PathVariable Long id, @RequestBody TyreDto tyreDto) {
        Tyre tyre = tyreMapper.toTyre(tyreDto);
        return tyreMapper.toTyreDto(tyreService.update(id, tyre));
    }

    @DeleteMapping("/tyres/{id}")
    public String deleteTyre(@PathVariable Long id) {
        tyreService.deleteById(id);
        return "Tyre with ID = " + id + " was deleted";
    }
}
