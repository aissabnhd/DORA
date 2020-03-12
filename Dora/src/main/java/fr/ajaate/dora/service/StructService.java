package fr.ajaate.dora.service;


import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.entities.enumeration.Level;
import fr.ajaate.dora.repository.StructRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StructService {

    @Autowired
    StructRepository structRepository;

    @Autowired
    StaffService staffService;

    public Struct createStruct(Struct s) {
        if(s.getStruct() == null) {
            structRepository.save(s);
        }
        else if(s.getStruct().getLevel() == Level.CARE_UNIT) {
            throw new IllegalArgumentException("Une Structure de niveau 5 ne peut avoir de sous structure !\n");
        }
        else if(getAllStaff(s.getStruct()).size() == 0) {
            throw new IllegalArgumentException("Une Structure n'ayant aucun personnel affecté ne peut avoir de sous structure\n");
        }

        else if(getStructResponsible(s.getStruct()) == null){
            throw new IllegalArgumentException("Affectez un responsable à la structure avant de lui créer une sous structure\n");
        }
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

    /*public void updateResponsible(Struct s, Staff staff) {
        Struct st = structRepository.findById(s.getId()).get();
        st.setResponsible(staff);
        structRepository.save(st);
    }
     */

    public void updateResponsible(Struct struct, Staff staff) {
        System.out.println("STRUCT SERVICE updateResponsible");
        staffService.updateStaffResponsible(staff, struct);
    }


    public List<Struct> getSubStruct(Struct struct) {
        List<Struct> l = new ArrayList<>();
        l.addAll(structRepository.findAllByStruct(struct));
        return l;
    }

    public Optional<Struct> getOne(Long id) {
        if(structRepository.existsById(id)) {
            return structRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Struct> getAll() {
        return structRepository.findAll();
    }

    public boolean deleteStruct(Long id) {
        if (!structRepository.existsById(id)) {
            return false;
        }
        Struct s = structRepository.findById(id).get();
        if((getSubStruct(s).size() == 0) && (getAllStaff(s).size() == 0) && (getStructResponsible(s) == null)) {
            structRepository.delete(s);
            return true;
        }
        return false;
    }

    /*public Staff getStructResponsible(Struct  struct) {
        Optional<Struct> s = structRepository.findById(struct.getId());
        if(s.isPresent()) {
            Struct str = s.get();
            return str.getResponsible();
        }
        return null;
    }

     */

    public Staff getStructResponsible(Struct struct) {
        Optional<Staff> staff = staffService.findByStructResponsible(struct);
        if(staff.isPresent()) {
            return staff.get();
        }
        return null;
    }

    public List<Staff> getAllStaff(Struct s) {
        List<Staff> l = new ArrayList<>();
        l.addAll(staffService.getAllFromStruct(s));
        return l;
    }

    public List<Struct> getStructByLevel(Level level) {
        List<Struct> lst = new ArrayList<>();
        lst.addAll(structRepository.findAllByLevel(level));
        return lst;
    }

}
