package fr.ajaate.dora.services;

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




    @Override
    public Staff findByUsername(String username) {
        return staffRepository.findByUsername(username);
    }

    @Override
    public Staff findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    @Override
    public Staff findByID(Long staffID) {
        return  staffRepository.findByID(staffID);
    }

    @Override
    public Staff updateVehicle(Long id, Staff newStaff) {

        if (staffRepository.findById(id).isPresent()){
            Staff existingStaff = staffRepository.findById(id).get();



            // String name, String firstname, Date birth, String
            //phone_number, String phone_number_secondary, String country, String city, String
            //postal_code, String street
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