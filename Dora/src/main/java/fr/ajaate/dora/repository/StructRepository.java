package fr.ajaate.dora.repository;

import fr.ajaate.dora.model.Struct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StructRepository extends CrudRepository<Struct, Long> {
    public Struct findByIdStruct(int idStruct);

    // Get the Responsible of the Struct
    public Struct findByIdResponsible(int idResponsible);

    // Get all the childs of the idStructParent Struct.
    public List<Struct> findByIdStructParent(int idStructParent);
}
