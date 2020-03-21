package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.EnvoyerEmail;
import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.services.StaffService;
import fr.ajaate.dora.services.StructService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StructService structService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void updateStaffResponsible(Staff s, Struct struct) {
        System.out.println("STAFF SERVICE updateStaffResponsible");

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

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }


    @Override
    public Optional<Staff> findByStructResponsible(Struct structResponsible) {
        return staffRepository.findByStructResponsible(structResponsible);
    }

    @Override
    public Staff save(Staff staff) {
        staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> findByEmail(String email) {
        return staffRepository.findByemail(email);
    }


    @Override
    public List<Staff> findByLastName(String lastname) {
        return staffRepository.findByLastName(lastname);
    }



    public Staff findByPhoneNumber(String phoneNumber) {
        return staffRepository.findByPhoneNumber(phoneNumber);
    }


    @Override
    public Staff findByID(Long staffID) {
        return  staffRepository.getOne(staffID);
    }

    @Override
    public Staff updateStaff(Long id, Staff newStaff) {

        if (staffRepository.findById(id).isPresent()){
            Staff existingStaff = staffRepository.findById(id).get();

            existingStaff.setFirstName(newStaff.getFirstName());
            existingStaff.setLastName(newStaff.getLastName());
            existingStaff.setBirthday(newStaff.getBirthday());
            existingStaff.setPhoneNumber(newStaff.getPhoneNumber());
            existingStaff.setCountry(newStaff.getCountry());
            existingStaff.setCity(newStaff.getCity());
            existingStaff.setPostcode(newStaff.getPostcode());
            existingStaff.setStreet(newStaff.getStreet());
            existingStaff.setRib(newStaff.getRib());
            existingStaff.setNationality(newStaff.getNationality());
            existingStaff.setPassword(newStaff.getPassword());


            Staff updatedStaff = staffRepository.save(existingStaff);

            return updatedStaff;
        }else{
            return null;
        }
    }

}
