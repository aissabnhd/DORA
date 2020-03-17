package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.AffectationRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.services.StructService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StructServiceImplementation implements StructService {


    @Autowired
    private StructRepository structRepository;

    @Override
    public List<Struct> findAll() {
        return structRepository.findAll();
    }
}
