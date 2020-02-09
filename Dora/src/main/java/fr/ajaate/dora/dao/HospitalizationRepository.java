package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {

    Set<Hospitalization> findAllByDateHospitalization(Instant dateHospitalization);

    Set<Hospitalization> findAllByDmpId(Long dmpId);

    Set<Hospitalization> findAllByStructId(Long structId);
}
