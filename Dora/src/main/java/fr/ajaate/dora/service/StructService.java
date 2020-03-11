package fr.ajaate.dora.service;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.entities.enumeration.Level;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface StructService {


    public Struct createStruct(Struct s) ;

    public void updateSpeciality(long structId, Speciality spe);

    public void updateParent(long structId, Struct parent);

    public void updateName(long structId, String name);

   // public void updateResponsible(Struct s, Staff staff) ;


    public List<Struct> getSubStruct(Struct struct) ;

    public Optional<Struct> getOne(Long id) ;

    public List<Struct> getAll() ;

    public boolean deleteStruct(Long id) ;

    //public Staff getStructResponsible(Struct  struct) ;

    public List<Staff> getAllStaff(Struct s);

    public List<Struct> getStructByLevel(Level level);

}
