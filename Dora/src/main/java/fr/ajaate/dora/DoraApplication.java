package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.enumeration.RoleName;
import fr.ajaate.dora.entities.Role;
import fr.ajaate.dora.entities.Staff;

import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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



		Role role2=new Role(RoleName.ADMINISTRATOR);
		Set<Role> roles2=new HashSet<>();
		roles2.add(role2);
		Staff staff2=new Staff("hamid","macron",Instant.parse("1993-01-01T10:12:35Z"),"franco-algerien","0000",
				"IBAN-BIC",93,roles2,"saint-denis","je sais pas ",
				"FR","hisAgenda","admin@gmail.com","admin");
		roleRepository.save(role2);
		staffService.save(staff2);



		Role role=new Role(RoleName.DOCTOR);
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		Staff staff=new Staff("hamid","macron",Instant.parse("1993-01-01T10:12:35Z"),"franco-algerien","0000",
				"IBAN-BIC",93,roles,"saint-denis","je sais pas ",
				"FR","hisAgenda","hamid-macron@gmail.com","123456789");
		roleRepository.save(role);
		staffService.save(staff);







	}
}
