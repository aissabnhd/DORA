package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Hospitalization;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HospitalizationServices {


    public Hospitalization save(Hospitalization hospitalization);

    public Hospitalization update(Hospitalization hospitalization);

    public List<Hospitalization> findAll();

    Optional<Hospitalization> findById(Long id);

    void deleteById(Long id);

    Set<Hospitalization> findAllByDateHospitalization(Instant dateHospitalization);

    Set<Hospitalization> findAllByDmpId(Long dmpId);

    Set<Hospitalization> findAllByStructId(Long structId);

}
