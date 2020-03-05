package fr.ajaate.dora.services;

import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Affectation;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public interface ActService {

    public Act save(Act act);

    public Act update(Act act);

    public List<Act> findAll();

    Optional<Act> findById(Long id);

    void deleteById(Long id);

    Set<Act> findAllByAffectationId(Long affectationId);

    Set<Act> findAllByDate(Instant date);
}
