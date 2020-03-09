package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AffectationServices {


    public Affectation save(Affectation Affectation);

    public Affectation update(Affectation Affectation);

    public List<Affectation> findAll();

    Optional<Affectation> findById(Long id);

    void deleteById(Long id);

    Set<Affectation> findAllByHospitalization(Long hospitalizationId);

    Set<Affectation> findAllByDateAffectation(Date dateAffectation);
}
