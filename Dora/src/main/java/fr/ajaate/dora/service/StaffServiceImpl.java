package fr.ajaate.dora.service;


import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Staff staff) {
        staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));

        staffRepository.save(staff);
    }

    @Override
    public Staff findByUsername(String username) {
        return staffRepository.findByUsername(username);
    }
/*
    @Override
    public Staff findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }*/
}
