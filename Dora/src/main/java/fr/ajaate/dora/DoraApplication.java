package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.enumeration.Level;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.*;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.enumeration.RoleName;
import fr.ajaate.dora.services.*;
import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.entities.DMP;
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
    private StructRepository structRepository;

    @Autowired
    private AffectationServices affectationServices;

	@Autowired
	StaffService staffService;


	@Autowired
	RoleRepository roleRepository;


    @Autowired
    private ActService actService;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private DocumentService documentService;


	public static void main(String[] args) {
		SpringApplication.run(DoraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
        /***************************************** DMP ********************************************/

        DMP dmp = dmpServices.save(new DMP("9912345746514253", "Karl", "Marks",
				new Date("1993/01/01"), "France", "+33784563452",
                "k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));
        DMP dmp2 = dmpServices.save(new DMP("9912345346584243", "Emile", "Zola",
				new Date("1993/01/01"), "France", "+33784563452",
                "e.zola@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));

        DMP dmp3 = dmpServices.save(new DMP("9912345748584263", "sara", "sara",
				new Date("1993/01/01"), "France", "+33784563452",
                "s.sara@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));


        /***************************************** Struct ********************************************/

        Struct struct = structRepository.save(new Struct("Val De grace", Level.HOSPITAL, 1,
                "Genève", "10 rue de La passerelle", "Suisse"));
        Struct struct2 = structRepository.save(new Struct("Salpêtrière", Level.HOSPITAL, 1,
                "Paris", "10 rue de La passerelle", "France"));


        /***************************************** Hospitalization ********************************************/

        Hospitalization hospitalization = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				new Date("1993/10/01"),
                13, dmp, struct));
        Hospitalization hospitalization1 = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				new Date("1993/11/01"),
                14, dmp, struct));
        Hospitalization hospitalization3 = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				null,
                14, dmp3, struct2));

		hospitalizationServices.save(hospitalization);
		hospitalizationServices.save(hospitalization1);
		hospitalizationServices.save(hospitalization3);

        /***************************************** Affectation ********************************************/

		Affectation affectation = affectationServices.save(new Affectation(new Date("1993/01/01"),
				null, hospitalization3, struct));
		Affectation affectation2 = affectationServices.save(new Affectation(new Date("1993/01/01"),
				new Date("1993/01/01"), hospitalization3, struct));


        /***************************************** Roles and Staff ********************************************/


		Role role=new Role(RoleName.DOCTOR);
		Set<Role> roles=new HashSet<>();
		roles.add(role);

		Staff staff=new Staff("hamid","macron",new Date("1993/11/01"),"franco-algerien","0000",
				"IBAN-BIC",93,roles,"saint-denis","je sais pas ",
				"FR","hisAgenda","hamida-macron@gmail.com","123456789");
		Role role3=new Role(RoleName.SECRETARY);
		Set<Role> roles3=new HashSet<>();
		roles3.add(role3);
		Staff staff3=new Staff("Thinhinane","Bouhaci",new Date("1995/22/02"),"franco-algerien","0000",
				"IBAN-BIC",93,roles3,"saint-denis","je sais pas ",
				"FR","hisAgenda","thinhinane-bouhaci@gmail.com","tina95");
		roleRepository.save(role);
		roleRepository.save(role3);
		staffService.save(staff);
		staffService.save(staff3);

		Role role4=new Role(RoleName.LABORATORY);
		Set<Role> roles4=new HashSet<>();
		roles4.add(role4);
		Staff staff4=new Staff("Benmammar","Eseid", new Date("1995/10/01"),"franco-algerien","0000",
				"IBAN-BIC",93,roles4,"saint-denis","je sais pas ",
				"FR","hisAgenda","eseid@gmail.com","eseid");
		roleRepository.save(role);
		roleRepository.save(role4);
		staffService.save(staff4);

		Role role5=new Role(RoleName.NURSE);
		Set<Role> roles5=new HashSet<>();
		roles5.add(role5);
		Staff staff5=new Staff("Benni","Jaid",new Date("1993/15/02"),"franco-algerien","0000",
				"IBAN-BIC",93,roles5,"saint-denis","je sais pas ",
				"FR","hisAgenda","jaid@gmail.com","jaja");
		roleRepository.save(role);
		roleRepository.save(role5);
		staffService.save(staff5);


        /***************************************** Act ********************************************/

        Act act = actService.save(new Act("scanner", Instant.now(), affectation, staff));


        /***************************************** Document ********************************************/

        Document document = documentService.save(new Document(DocumentNature.TEXT,DocumentType.CR, ".txt", new Date(),
                "./src/main/assets/cr/crKarl.txt", act, staff));

        documentService.setDocumentContent("ceci est un test", document.getPath());

    }

}
