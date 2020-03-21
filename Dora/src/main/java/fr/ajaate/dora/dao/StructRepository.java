package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.enumeration.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StructRepository extends JpaRepository<Struct, Long> {
    public List<Struct> findAllByStruct(Struct s);
    public Staff findByResponsible(Struct s);
    public List<Struct> findAllByLevel(Level level);

}
