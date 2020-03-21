package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
