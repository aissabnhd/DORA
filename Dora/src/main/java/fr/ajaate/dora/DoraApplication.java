package fr.ajaate.dora;

import fr.ajaate.dora.dao.*;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.enumeration.Level;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.*;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.enumeration.RoleName;
import fr.ajaate.dora.services.*;
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

    @Autowired
	private SpecialityRepository specialityRepository;


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

        /*Struct struct = structRepository.save(new Struct("Val De grace", Level.HOSPITAL, 1,
                "Genève", "10 rue de La passerelle", "Suisse"));
        Struct struct2 = structRepository.save(new Struct("Salpêtrière", Level.HOSPITAL, 1,
                "Paris", "10 rue de La passerelle", "France"));
*/



        Speciality spe1 = new Speciality("Chirurgie");
		specialityRepository.save(spe1);

		Speciality spe2 = new Speciality("Réanimation");
		specialityRepository.save(spe2);

		Struct struct = structRepository.save(new Struct("APHP", Level.APHP, 75001, "Paris", "15 Rue de la Bienfaisance", "France", null, null, null));
		/*Struct struct2 = structRepository.save(new Struct("Salpêtrière", Level.HOSPITAL, 75005, "Paris", "30 avenue de la grandea armée", "France", spe1, struct, null));
		Struct struct3 = structRepository.save(new Struct("Salpêtrière Pole 1", Level.POLE, 75005, "Paris", "30 avenue de la grandea armée","France", spe1,struct2, null));
		Struct struct4 = structRepository.save(new Struct("Salpêtrière Service 1", Level.SERVICE, 75005,"Paris", "30 avenue de la grandea armée","France", spe1, struct3,null));
		Struct struct5 = structRepository.save(new Struct("Salpetriêre Unité Fonctionnelle 1", Level.FONCTIONAL_UNIT,75005, "Paris", "30 avenue de la grandea armée", "France", spe1, struct4, null));
		Struct struct6 = structRepository.save(new Struct("Salpêtrière Unité de Soin 1", Level.CARE_UNIT, 75005, "Paris", "30 avenue de la grandea armée", "France", spe1, struct5, null));*/
		Struct struct7 = structRepository.save(new Struct("Hôpital Bicetre", Level.HOSPITAL, 94270, "Le Kremlin-Bicêtre", "78 Rue du Général Leclerc", "France", spe2, struct, null));
        /***************************************** Hospitalization ********************************************/

        Hospitalization hospitalization = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				new Date("1993/10/01"),
                13, dmp, struct));
        Hospitalization hospitalization1 = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				new Date("1993/11/01"),
                14, dmp, struct));
        Hospitalization hospitalization3 = hospitalizationServices.save(new Hospitalization(new Date("1993/01/01"),
				null,
                14, dmp3, struct7));

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

		Staff staff=new Staff("Sebastien","Jean",new Date("1993/11/01"),"française","0674305745",
				"IBAN-BIC",94,roles,"Evry","3 rue Pasteur",
				"FR","hisAgenda","sebastien-jean@gmail.com","123456789");

		Role role2=new Role(RoleName.ADMINISTRATOR);
		Set<Role> roles2=new HashSet<>();
		roles2.add(role2);



		Staff staff2=new Staff("admin","Aïssa",new Date("1993/11/01"),"française","0622571243",
				"IBAN-BIC",77,roles2,"Torcy","70 rue de la gare",
				"FR","hisAgenda","aissa.bnhd@gmail.com","admin");
		Role role3=new Role(RoleName.SECRETARY);
		Set<Role> roles3=new HashSet<>();
		roles3.add(role3);
		Staff staff3=new Staff("Thinhinane","Bouhaci",new Date("1995/22/02"),"algérienne","0630483625",
				"IBAN-BIC",95,roles3,"Montmagny","57 avenue de la paix",
				"FR","hisAgenda","thinhinane.bouhaci@gmail.com","tina95");
		roleRepository.save(role);
		roleRepository.save(role2);
		roleRepository.save(role3);
		staffService.save(staff);
		staffService.save(staff2);
		staffService.save(staff3);

		Role role4=new Role(RoleName.LABORATORY);
		Set<Role> roles4=new HashSet<>();
		roles4.add(role4);
		Staff staff4=new Staff("Eseid","Benmamamr", new Date("1995/10/01"),"algérienne","0677939294",
				"IBAN-BIC",93,roles4,"saint-denis","34 rue du peuplier",
				"FR","hisAgenda","eseid@gmail.com","eseid");
		roleRepository.save(role);
		roleRepository.save(role4);
		staffService.save(staff4);

		Role role5=new Role(RoleName.NURSE);
		Set<Role> roles5=new HashSet<>();
		roles5.add(role5);
		Staff staff5=new Staff("Jaid","Benni",new Date("1993/15/02"),"française","0614542849",
				"IBAN-BIC",77,roles5,"Meaux","20 allée des roses",
				"FR","hisAgenda","jaid@gmail.com","jaja");
		roleRepository.save(role);
		roleRepository.save(role5);
		staffService.save(staff5);


        /***************************************** Act ********************************************/

        Act act = actService.save(new Act("scanner", new Date(), affectation, staff, true));
		Act act2 = actService.save(new Act("radio", new Date(), affectation, staff, true));


        /***************************************** Document ********************************************/

        Document document = documentService.save(new Document(DocumentNature.TEXT,DocumentType.CR, ".txt", new Date(),
                "./src/main/assets/cr/crKarl.txt", act, staff));


    }

}
