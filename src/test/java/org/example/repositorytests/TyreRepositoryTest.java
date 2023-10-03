package org.example.repositorytests;


import org.example.AbstractIntegrationTest;
import org.example.configuration.Config;
import org.example.model.entity.Tyre;
import org.example.model.repository.TyreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(classes = {Config.class, TyreRepository.class})
public class TyreRepositoryTest extends AbstractIntegrationTest {

    private final TyreRepository tyreRepository;

    @Autowired
    public TyreRepositoryTest(TyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    @Test
    @Sql("/db.sql")
    public void findById() {
        Tyre tyre1 = new Tyre();
        tyre1.setSeason("Summer");
        tyre1.setName("Bridgestone");
        tyre1 = tyreRepository.save(tyre1);
        Tyre tyre2 = new Tyre();
        tyre2.setSeason("Winter");
        tyre2.setName("Michelin");
        tyre2 = tyreRepository.save(tyre2);
        Tyre currentTyre1 = tyreRepository.findById(tyre1.getId()).orElseThrow();
        Tyre currentTyre2 = tyreRepository.findById(tyre2.getId()).orElseThrow();
        List<Tyre> tyres = new ArrayList<>();
        tyres.add(currentTyre1);
        tyres.add(currentTyre2);
        assertEquals(2, tyres.size());
        assertTrue(tyres.contains(currentTyre1));
        assertTrue(tyres.contains(currentTyre2));
        tyreRepository.delete(tyre1);
        tyreRepository.delete(tyre2);
    }
}
