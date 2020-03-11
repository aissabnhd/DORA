package fr.ajaate.dora.service.impl;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.entities.enumeration.Level;
import fr.ajaate.dora.repository.StructRepository;
import fr.ajaate.dora.service.StructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StructServiceImplementation implements StructService {

    @Autowired
    StructRepository structRepository;

    @Autowired
    StaffServiceImplementation staffServiceImplementation;

    public Struct createStruct(Struct s) {
        if(s.getStruct() == null) {
            if(structRepository.existsByNameStruct(s.getNameStruct()))
                throw new IllegalArgumentException("Une structure avec le nom " + s.getNameStruct() + " exist déja !\n");
            return structRepository.save(s);
        }
        else if(s.getStruct().getLevel() == Level.CARE_UNIT) {
            throw new IllegalArgumentException("Une Structure de niveau 5 ne peut avoir de sous structure !\n");
        }
        /*
        else if(getAllStaff(s.getStruct()).size() == 0) {
            throw new IllegalArgumentException("Une Structure n'ayant aucun personnel affecté ne peut avoir de sous structure\n");
        }

        else if(getStructResponsible(s.getStruct()) == null){
            throw new IllegalArgumentException("Affectez un responsable à la structure avant de lui créer une sous structure\n");
        }
*/
        return structRepository.save(s);
    }

    public void updateSpeciality(long structId, Speciality spe) {
        Struct s = structRepository.findById(structId).get();
        s.setSpeciality(spe);
        structRepository.save(s);
    }

    public void updateParent(long structId, Struct parent) {
        Struct s = structRepository.findById(structId).get();
        s.setStruct(parent);
        structRepository.save(s);
    }

    public void updateName(long structId, String name) {
        Struct s = structRepository.findById(structId).get();
        s.setNameStruct(name);
        structRepository.save(s);
    }
/*
    public void updateResponsible(Struct s, Staff staff) {
        Struct st = structRepository.findById(s.getId()).get();
        st.setResponsible(staff);
        structRepository.save(st);
    }
*/
    public List<Struct> getSubStruct(Struct struct) {
        List<Struct> l = new ArrayList<>();
        l.addAll(structRepository.findAllByStruct(struct));
        return l;
    }

    public Optional<Struct> getOne(Long id) {
        return structRepository.findById(id);
    }

    public List<Struct> getAll() {
        return structRepository.findAll();
    }

    public boolean deleteStruct(Long id) {
        if (!structRepository.existsById(id)) {
            throw new IllegalArgumentException("id : " + id + " Structure n'existe pas");
        }
        Struct s = structRepository.findById(id).get();
        /*
        if((getSubStruct(s).size() == 0) && (getAllStaff(s).size() == 0) && (getStructResponsible(s) == null)) {
            structRepository.delete(s);
            return true;
        }

         */
        return false;
    }

    @Override
    public List<Staff> getAllStaff(Struct s) {
        return null;
    }
/*
    public Staff getStructResponsible(Struct  struct) {
        Optional<Struct> s = structRepository.findById(struct.getId());
        if(s.isPresent()) {
            Struct str = s.get();
            return str.getResponsible();
        }
        return null;
    }

 */


    public List<Struct> getStructByLevel(Level level) {
        List<Struct> lst = new ArrayList<>();
        lst.addAll(structRepository.findAllByLevel(level));
        return lst;
    }

}
