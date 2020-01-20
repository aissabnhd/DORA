package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.DMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMPRepository extends JpaRepository<DMP, Long> {
}
