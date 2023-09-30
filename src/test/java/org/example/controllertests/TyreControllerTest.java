package org.example.controllertests;

import org.example.controller.TyreController;
import org.example.model.dto.TyreDto;
import org.example.model.entity.Tyre;
import org.example.model.mapper.TyreMapper;
import org.example.service.TyreService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TyreControllerTest {

    @Mock
    private TyreService tyreService;
    @Spy
    private TyreMapper tyreMapper = Mappers.getMapper(TyreMapper.class);
    @InjectMocks
    private TyreController tyreController;

    @Test
    public void createTyre() {
        when(tyreService.create(any(Tyre.class))).thenReturn(new Tyre());
        tyreController.createTyre(new TyreDto());
        verify(tyreMapper).toTyre(any(TyreDto.class));
        verify(tyreService).create(any(Tyre.class));
        verify(tyreMapper).toTyreDto(any(Tyre.class));
    }

    @Test
    public void readOneTyre() {
        when(tyreService.readById(any(Long.class))).thenReturn(new Tyre());
        tyreController.readOneTyre(1L);
        verify(tyreService).readById(1L);
        verify(tyreMapper).toTyreDto(any(Tyre.class));
    }

    @Test
    public void readAllTyres() {
        when(tyreService.readAll()).thenReturn(Collections.emptyList());
        tyreController.readAllTyres();
        verify(tyreService).readAll();
        verify(tyreMapper).toTyreDtoList(any());
    }

    @Test
    public void updateTyre() {
        when(tyreService.update(any(Long.class), any(Tyre.class))).thenReturn(new Tyre());
        tyreController.updateTyre(1L, new TyreDto());
        verify(tyreMapper).toTyre(any(TyreDto.class));
        verify(tyreService).update(any(Long.class), any(Tyre.class));
        verify(tyreMapper).toTyreDto(any(Tyre.class));
    }

    @Test
    public void deleteTyre() {
        doNothing().when(tyreService).deleteById(any(Long.class));
        tyreController.deleteTyre(1L);
        verify(tyreService).deleteById(any(Long.class));
    }
}
