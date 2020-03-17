package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {

    Set<Affectation> findAllByDateAffectation(Date dateAffectation);

    Set<Affectation> findAllByHospitalizationId(Long hospitalizationId);


}
