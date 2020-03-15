package fr.ajaate.dora.service;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StructService structService;

    public Staff createStaff(Staff s) {
        return staffRepository.save(s);
    }

    public void updateStaffResponsible(Staff s, Struct struct) {
        System.out.println("STAFF SERVICE updateStaffResponsible");

        /*Optional <Staff> staff = staffRepository.findById(s.getId());
        if(staff.isPresent()) {
            System.out.println("STAFF IS PRESENT");
            Staff newStaff = staff.get();
            System.out.println(newStaff.getId());
            System.out.println(struct.getId());
            newStaff.setStructResponsible(struct);
            System.out.println("setStructResponsible done");
            staffRepository.save(newStaff);
        }
        System.out.println("STAFF IS NOT PRESENT");

         */
        System.out.println("STAFF IS PRESENT");
        System.out.println(s.getId());
        System.out.println(struct.getId());
        System.out.println(s.getStructResponsible());
        s.setStructResponsible(struct);
        System.out.println(s.getStructResponsible());
        System.out.println("setStructResponsible done");
        staffRepository.save(s);
    }


    public Optional<Staff> getOne(Long id) {
        if(staffRepository.existsById(id)) {
            return staffRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Staff> getAllFromStruct(Struct struct) {
        List<Staff> listUser = new ArrayList<>();
        listUser.addAll(staffRepository.findAllByStructBelong(struct));
        return listUser;
    }

    public boolean deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            return false;
        }
        Staff s = staffRepository.findById(id).get();
        staffRepository.delete(s);
        return true;
        }

    public boolean affectStaffToStruct(Long idStaff, long idStruct) {
        Optional <Staff> staff = getOne(idStaff);
        Optional <Struct> struct = structService.getOne(idStruct);
        if(staff.isPresent() && struct.isPresent()) {
            Staff s = staff.get();
            Struct str = struct.get();
            if(s.getSpecialities().contains(str.getSpeciality())) {
                s.setStructBelong(str);
                staffRepository.save(s);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStaffToStruct(Long idStaff, Long idStruct) {
        Optional <Staff> staff = getOne(idStaff);
        Optional <Struct> struct = structService.getOne(idStruct);
        if(staff.isPresent() && struct.isPresent()) {
            Staff s = staff.get();
            Struct str = struct.get();
            if(structService.getStructResponsible(str) != null) {
                return false;
            }
            s.setStructBelong(null);
            staffRepository.save(s);
            return true;
        }
        return false;
    }

    public Struct getStructAffectation(Staff s) {
        Optional<Staff> staff = getOne(s.getId());
        if(staff.isPresent()) {
            Staff s2 = staff.get();
            Struct str = s2.getStructBelong();
            if(str == null) {
                return null;
            }
            return str;
        }
        return null;
    }

    public Staff findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    public List<Staff> findByLastName(String lastname) {
        return staffRepository.findByLastName(lastname);
    }


    public Optional<Staff> findByStructResponsible(Struct structResponsible) {
        return staffRepository.findByStructResponsible(structResponsible);
    }

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    public Optional<Staff> findByPhoneNumber(String phoneNumber) {
        return staffRepository.findByPhoneNumber(phoneNumber);
    }


}



