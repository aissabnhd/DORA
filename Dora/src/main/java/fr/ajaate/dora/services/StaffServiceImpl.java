package fr.ajaate.dora.services;

import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

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
    public Optional<Staff> findByEmail(String email) {
        return staffRepository.findByemail(email);
    }

    @Override
    public Staff findByID(Long staffID) {
        return  staffRepository.getOne(staffID);
    }

    @Override
    public Staff updateStaff(Long id, Staff newStaff) {

        if (staffRepository.findById(id).isPresent()){
            Staff existingStaff = staffRepository.findById(id).get();

            existingStaff.setFirsName(newStaff.getFirsName());
            existingStaff.setLastName(newStaff.getLastName());
            existingStaff.setBirthday(newStaff.getBirthday());
            existingStaff.setPhoneNumber(newStaff.getPhoneNumber());
            existingStaff.setCountry(newStaff.getCountry());
            existingStaff.setCity(newStaff.getCity());
            existingStaff.setPostcode(newStaff.getPostcode());
            existingStaff.setStreet(newStaff.getStreet());


            Staff updatedStaff = staffRepository.save(existingStaff);

            return updatedStaff;
        }else{
            return null;
        }
    }
}
