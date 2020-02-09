package fr.ajaate.dora.services;

import fr.ajaate.dora.entities.DMP;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DMPServices {

    public DMP save(DMP dmp);

    public DMP update(DMP dmp);

    public List<DMP> findAll();

    Optional<DMP> findById(Long id);

    void deleteById(Long id);

    public List<DMP> findByLastName(String lastName);

    public List<DMP> findByFirstName(String firstName);

    public Optional<DMP> findBySocialSecurityNumber(String socialSecurityNumber);

    Set<DMP> findAllByStructId(Long structId);


}
