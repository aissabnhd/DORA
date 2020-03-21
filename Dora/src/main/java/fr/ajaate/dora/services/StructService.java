package fr.ajaate.dora.services;

import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


public interface StructService {
    Struct createStruct(Struct s);

    public Staff getStructResponsible(Struct struct);

    List<Struct> getAll();

    Optional<Struct> getOne(Long id);

    boolean deleteStruct(Long id);
}
