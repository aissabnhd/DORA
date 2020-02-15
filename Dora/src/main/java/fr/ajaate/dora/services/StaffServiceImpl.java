package fr.ajaate.dora.services;

import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;



    @Override
    public void save(Staff staff) {
        //staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));

        staffRepository.save(staff);
    }
    @Override
    public Staff findByUsername(String username) {
        return staffRepository.findByusername(username);
    }

    @Override
    public Staff findByEmail(String email) {
        return staffRepository.findByemail(email);
    }

    @Override
    public Staff findByID(Long staffID) {
        return  staffRepository.findByID(staffID);
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