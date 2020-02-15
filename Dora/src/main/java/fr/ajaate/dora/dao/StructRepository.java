package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Struct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructRepository extends JpaRepository<Struct, Long> {
}
