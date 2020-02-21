package fr.ajaate.dora.services;

import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<String> Login(String email, String password) {
        List<String> info = new ArrayList<>();
      Staff staff = staffRepository.findByemail(email);

      System.out.println("staf ********************");
      System.out.println(staff);


        System.out.println(staff.getPassword());
        if ( bCryptPasswordEncoder.matches(password, staff.getPassword()))
        {
            info.add(staff.getFirsName());
            info.add(staff.getLastName());
            //info.add(staff.getRole().getRoleName().name());
        }

        else {  info.add( "coudn't authentificate ");}

        return  info ;
    }
}
