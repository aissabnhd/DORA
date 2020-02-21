package fr.ajaate.dora.controllers;

import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.SecurityService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationControllor {


    @Autowired
    private SecurityService securityService;

    @Autowired
    private StaffRepository staffRepository;

     List<Staff> authetifiedUsers = new ArrayList<>();


    @RequestMapping(path = "/login/{login}/{password}", method = RequestMethod.GET)
    public List<String> connect(@PathVariable String email, @PathVariable String password){
        try{

            List<String> logininfo= securityService.Login(email, password);
            authetifiedUsers.add(staffRepository.findByemail(email));
            System.out.println("****************************** je suis dans le controleur *************");
            System.out.println(email+password);
            return logininfo;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong login and password");
        }
    }

}
