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

    public Staff createStaff(Staff s) {
        return staffRepository.save(s);
    }


    public Optional<Staff> getOne(Long id) {
        return staffRepository.findById(id);
    }

    public List<Staff> getAllFromStruct(Struct struct) {
        List<Staff> listUser = new ArrayList<>();
        listUser.addAll(staffRepository.findAllByStructBelong(struct));
        return listUser;
    }



}
