package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
	@Autowired
	private DMPServices dmpServices;

	@Autowired
	private HospitalizationServices hospitalizationServices;

	@Autowired
	StaffService staffService;


	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private StructRepository structRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		DMP dmp = new DMP("9912345746534253", "Karl", "Marks",
				null, "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");
		DMP dmp2 = new DMP("9912345746584243", "Emile", "Zola",
				null, "France", "+33784563452",
				"e.zola@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");

		DMP dmp3 = new DMP("10", "sara", "sara",
				null, "France", "+33784563452",
				"s.sara@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");

		dmp = dmpServices.save(dmp);
		dmp2 = dmpServices.save(dmp2);
		dmp3 = dmpServices.save(dmp3);
		Struct struct = structRepository.save(new Struct("Val De grace", 2, 1, "Genève", "10 rue de La passerelle", "Suisse"));
		Struct struct2 = structRepository.save(new Struct("Salpêtrière", 2, 1, "Paris", "10 rue de La passerelle", "France"));

		Hospitalization hospitalization = new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"), 13, dmp, struct);
		Hospitalization hospitalization1 = new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"), 14, dmp2, struct);
		Hospitalization hospitalization3 = new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"), 14, dmp3, struct2);

		System.out.println(" id hospitalisation : " + hospitalization.getId());
		hospitalizationServices.save(hospitalization);
		hospitalizationServices.save(hospitalization1);
		hospitalizationServices.save(hospitalization3);
		//Set<DMP> dmpSet = dmpServices.findAllByStructId(struct.getId());
		//System.out.println(dmpSet);



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
		Role role3=new Role(RoleName.SECRETARY);
		Set<Role> roles3=new HashSet<>();
		roles3.add(role3);
		Staff staff3=new Staff("Thinhinane","Bouhaci",Instant.parse("1993-01-01T10:12:35Z"),"franco-algerien","0000",
				"IBAN-BIC",93,roles3,"saint-denis","je sais pas ",
				"FR","hisAgenda","thinhinane-bouhaci@gmail.com","tina95");
		roleRepository.save(role);
		roleRepository.save(role3);
		staffService.save(staff);
		staffService.save(staff3);

		Role role4=new Role(RoleName.LABORATORY);
		Set<Role> roles4=new HashSet<>();
		roles4.add(role4);
		Staff staff4=new Staff("Benmammar","Eseid",Instant.parse("1993-01-01T10:12:35Z"),"franco-algerien","0000",
				"IBAN-BIC",93,roles4,"saint-denis","je sais pas ",
				"FR","hisAgenda","eseid@gmail.com","eseid");
		roleRepository.save(role);
		roleRepository.save(role4);
		staffService.save(staff);
		staffService.save(staff4);

		Role role5=new Role(RoleName.NURSE);
		Set<Role> roles5=new HashSet<>();
		roles5.add(role5);
		Staff staff5=new Staff("Benni","Jaid",Instant.parse("1993-01-01T10:12:35Z"),"franco-algerien","0000",
				"IBAN-BIC",93,roles5,"saint-denis","je sais pas ",
				"FR","hisAgenda","jaid@gmail.com","jaja");
		roleRepository.save(role);
		roleRepository.save(role5);
		staffService.save(staff);
		staffService.save(staff5);






	}
}
