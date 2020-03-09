package fr.ajaate.dora;

import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.*;
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
    private ActService actService;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private DocumentService documentService;


    @Autowired
    StaffService staffService;


    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /***************************************** DMP ********************************************/

        DMP dmp = dmpServices.save(new DMP("9912345746514253", "Karl", "Marks",
                Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
                "k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));
        DMP dmp2 = dmpServices.save(new DMP("9912345346584243", "Emile", "Zola",
                Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
                "e.zola@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));

        DMP dmp3 = dmpServices.save(new DMP("9912345748584263", "sara", "sara",
                Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
                "s.sara@gmail.com", 75001, "Paris", "Boulevard saint-denis",
                "France", "allergy"));


        /***************************************** Struct ********************************************/

        Struct struct = structRepository.save(new Struct("Val De grace", 2, 1,
                "Genève", "10 rue de La passerelle", "Suisse"));
        Struct struct2 = structRepository.save(new Struct("Salpêtrière", 2, 1,
                "Paris", "10 rue de La passerelle", "France"));


        /***************************************** Hospitalization ********************************************/

        Hospitalization hospitalization = hospitalizationServices.save(new Hospitalization(Instant.now(),
                Instant.parse("2020-03-01T10:12:35Z"),
                13, dmp, struct));
        Hospitalization hospitalization1 = hospitalizationServices.save(new Hospitalization(Instant.now(),
                Instant.parse("2020-03-01T10:12:35Z"),
                14, dmp, struct));
        Hospitalization hospitalization3 = hospitalizationServices.save(new Hospitalization(Instant.now(),
                Instant.parse("2020-03-01T10:12:35Z"),
                14, dmp3, struct2));


        /***************************************** Affectation ********************************************/

        Affectation affectation = affectationServices.save(new Affectation(Instant.parse("1993-01-01T10:12:35Z"),
                Instant.parse("1993-01-01T10:12:35Z"), hospitalization, struct));


        /***************************************** Roles and Staff ********************************************/

        Role role = new Role(RoleName.DOCTOR);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        Staff staff = new Staff("hamid", "macron", Instant.parse("1993-01-01T10:12:35Z"), "franco-algerien", "0000",
                "IBAN-BIC", 93, roles, "saint-denis", "je sais pas ",
                "FR", "hisAgenda", "hamid-macron@gmail.com", "123456789");
        role = roleRepository.save(role);
        staff = staffService.save(staff);

        Role role2 = new Role(RoleName.ADMINISTRATOR);
        role2 = roleRepository.save(role2);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(role2);
        Staff staff2 = new Staff("hamid", "macron", Instant.parse("1993-01-01T10:12:35Z"), "franco-algerien",
                "0000", "IBAN-BIC", 93, roles2, "saint-denis", "je sais pas ",
                "FR", "hisAgenda", "admin@gmail.com", "admin");
        staff2 = staffService.save(staff2);


        /***************************************** Act ********************************************/

        Act act = actService.save(new Act("scanner", Instant.now(), affectation, staff));


        /***************************************** Document ********************************************/

        Document document = documentService.save(new Document(DocumentType.TEXT, ".txt", Instant.now(),
                "./file.txt", act, staff));


    }

}