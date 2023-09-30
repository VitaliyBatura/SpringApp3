package org.example.servicetests;

import org.example.model.entity.Tyre;
import org.example.model.repository.TyreRepository;
import org.example.service.impl.TyreServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TyreServiceImplTest {
    @Mock
    private TyreRepository tyreRepository;
    @InjectMocks
    private TyreServiceImpl tyreService;

    @Test
    public void create() {
        when(tyreRepository.save(any(Tyre.class))).thenReturn(new Tyre());
        tyreService.create(new Tyre());
        verify(tyreRepository).save(any(Tyre.class));
    }

    @Test
    public void readById() {
        when(tyreRepository.findById(any(Long.class))).thenReturn(Optional.of(new Tyre()));
        tyreService.readById(1L);
        verify(tyreRepository).findById(1L);
    }

    @Test
    public void readAll() {
        when(tyreRepository.findAll()).thenReturn(Collections.emptyList());
        tyreService.readAll();
        verify(tyreRepository).findAll();
    }

    @Test
    public void update() {
        Tyre tyre = new Tyre();
        when(tyreRepository.save(any(Tyre.class))).thenReturn(tyre);
        tyreService.update(13L, tyre);
        assertEquals(13L, tyre.getId());
        verify(tyreRepository).save(any(Tyre.class));
    }

    @Test
    public void deleteById() {
        doNothing().when(tyreRepository).deleteById(anyLong());
        tyreService.deleteById(21L);
        verify(tyreRepository).deleteById(21L);
    }
}