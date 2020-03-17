package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.DMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DMPRepository extends JpaRepository<DMP, Long> {

    List<DMP> findAllByLastName(String lastName);

    List<DMP> findAllByFirstName(String firstName);

    Optional<DMP> findBySocialSecurityNumber(String socialSecurityNumber);

    boolean existsDMPBySocialSecurityNumber(String socialSecurityNumber);

    @Query("SELECT dmp from DMP as dmp, Hospitalization h where dmp.id = h.dmp.id and h.struct.id = :structId")
    Set<DMP> findAllByStructId(@Param("structId") Long structId);

}
