package fr.ajaate.dora.service;

import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StructService structService;

    public Staff createStaff(Staff s) {
        return staffRepository.save(s);
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


    }




