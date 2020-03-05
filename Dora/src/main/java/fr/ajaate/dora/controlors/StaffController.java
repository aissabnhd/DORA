package fr.ajaate.dora.controlors;

import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public ResponseEntity<List<Staff>> findAll() {
        return new ResponseEntity<List<Staff>>(staffRepository.findAll(), HttpStatus.OK);
    }

}
