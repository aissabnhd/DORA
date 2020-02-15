package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Role;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.enumeration.RoleName;
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
    @Autowired
    private DMPRepository dmpRepository;



	@Autowired
	StaffService staffService;


	@Autowired
	RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		dmpRepository.save(new DMP("9912345746534253", "Karl", "Marks",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy"));


		Instant instant = Instant.now();
		dmpRepository.save(new DMP("9912345746534253", "Karl", "Marks",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy"));
		Role role=new Role(RoleName.DOCTOR);
		Staff staff=new Staff("hamid","macron",instant,"franco-algerien","0000",
				"IBAN-BIC",93,role,"saint-denis","je sais pas ",
				"FR","hisAgenda","hmacron","hamid-macron@gmail.com","123456789");
		roleRepository.save(role);
		staffService.save(staff);

		Staff s= staffService.findByUsername("hmacron");
		System.out.println(s.toString());


		System.out.println ("********************************");

		//System.out.println (securityService.autoLogin("hmacron",s.getPassword()));

	}
}
