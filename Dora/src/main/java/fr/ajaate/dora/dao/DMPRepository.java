package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.DMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DMPRepository extends JpaRepository<DMP, Long> {

    List<DMP> findAllByLastName(String lastName);

    List<DMP> findAllByFirsName(String firstName);

    Optional<DMP> findBySocialSecurityNumber(String socialSecurityNumber);

    boolean existsDMPBySocialSecurityNumber(String socialSecurityNumber);

}
