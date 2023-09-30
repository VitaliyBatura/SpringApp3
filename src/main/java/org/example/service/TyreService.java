package org.example.service;

import org.example.model.entity.Tyre;

import java.util.List;

public interface TyreService {

    Tyre create(Tyre tyre);

    Tyre readById(Long id);

    List<Tyre> readAll();

    Tyre update(Long id, Tyre tyre);

    void deleteById(Long id);
}
