package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Set;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {
    Set<Act> findAllByDate(Instant dateAffectation);

    Set<Act> findAllByAffectationId(Long affectationId);

}
