package fr.ajaate.dora.repository;

import fr.ajaate.dora.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    List<Speciality> findByNameRole(String role);
}
