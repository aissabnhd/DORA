package fr.ajaate.dora.repository;

import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.entities.enumeration.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructRepository extends JpaRepository<Struct, Long> {

    public boolean existsByNameStruct(String nameStruct);

    public List<Struct> findAllByStruct(Struct s);
   // public Staff findByResponsible(Struct s);
    public List<Struct> findAllByLevel(Level level);
    public List<Struct> findStructByNameStruct(String nameStruct);

}
