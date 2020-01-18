package fr.ajaate.dora.service;

import fr.ajaate.dora.model.Level;
import fr.ajaate.dora.model.Struct;
import fr.ajaate.dora.repository.StructRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructService {

    @Autowired
    StructRepository structRepository;

    public Struct createStruct(Struct s){
        return structRepository.save(s);
    }

    public Optional<Struct> getOne(Long id) {
        return structRepository.findById(id);
    }

    public Iterable<Struct> getAll() {
        return structRepository.findAll();
    }

    public void main(String[] args) {
        Struct s = new Struct(1, "Clinique", Level.HOSPITAL, "France", "Paris", "75016","Avenue de la grande armée", "15", null, 2 );
        createStruct(s);
        System.out.println(getAll());
    }

}
