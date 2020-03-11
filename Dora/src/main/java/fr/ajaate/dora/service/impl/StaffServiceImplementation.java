package fr.ajaate.dora.service.impl;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.repository.StaffRepository;
import fr.ajaate.dora.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StaffServiceImplementation implements StaffService {
    @Autowired
    StaffRepository staffRepository;


    @Override
    public Staff createStaff(Staff staff) {
        if(staffRepository.existsByPhoneNumber(staff.getPhoneNumber()))
            throw new IllegalArgumentException("un personnel avec le méme numéro de téléphone existe déja !");
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        if(!staffRepository.existsById(staff.getId()))
            throw new IllegalArgumentException("le personnel que vous modifier n'existe pas");
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Set<Staff> findAllByLastName(String lastName) {
        return staffRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<Staff> findAllByFirsName(String firstName) {
        return staffRepository.findAllByFirsName(firstName);
    }

    @Override
    public Optional<Staff> findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    @Override
    public Optional<Staff> findByPhoneNumber(String phoneNumber) {
        return staffRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Set<Staff> findAllByStaffSpeciality(Speciality speciality) {
        return staffRepository.findAllBySpecialitiesIsContaining(speciality);
    }

    @Override
    public Set<Staff> findAllByStructBelongId(Long structBelongId) {
        return staffRepository.findAllByStructBelongId(structBelongId);
    }

    @Override
    public Optional<Staff> findByStructResponsible(Struct structResponsible) {
        return staffRepository.findByStructResponsible(structResponsible);
    }
}
