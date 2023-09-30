package org.example.service.impl;

import org.example.model.entity.Tyre;
import org.example.model.repository.TyreRepository;
import org.example.service.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TyreServiceImpl implements TyreService {

    private TyreRepository tyreRepository;

    @Autowired
    public TyreServiceImpl(TyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    @Override
    @Transactional
    public Tyre create(Tyre tyre) {
        return tyreRepository.save(tyre);
    }

    @Override
    @Transactional
    public Tyre readById(Long id) {
        return tyreRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public List<Tyre> readAll() {
        return new ArrayList<>((Collection) tyreRepository.findAll());
    }

    @Override
    @Transactional
    public Tyre update(Long id, Tyre tyre) {
        tyre.setId(id);
        return tyreRepository.save(tyre);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tyreRepository.deleteById(id);
    }
}