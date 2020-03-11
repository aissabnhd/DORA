package fr.ajaate.dora;

import fr.ajaate.dora.entities.*;
import fr.ajaate.dora.entities.enumeration.Level;
import fr.ajaate.dora.entities.enumeration.RoleName;
import fr.ajaate.dora.repository.RoleRepository;
import fr.ajaate.dora.repository.SpecialityRepository;
import fr.ajaate.dora.repository.StaffRepository;
import fr.ajaate.dora.repository.StructRepository;
import fr.ajaate.dora.service.StaffService;
import fr.ajaate.dora.service.impl.StaffServiceImplementation;
import fr.ajaate.dora.service.StructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
    @Autowired
    private StructRepository structRepository;

    @Autowired
	private SpecialityRepository specialityRepository;

    @Autowired
	private StructService structService;

    @Autowired
	private StaffService staffService;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

               Role role = new Role(RoleName.ADMINISTRATOR);

               roleRepository.save(role);

                System.out.println("Create APHP\n");
                Struct aphp = new Struct("APHP", Level.APHP, null);
                structService.createStruct(aphp);

                Struct parisHopital = new Struct("HOPITAL PARIS", Level.HOSPITAL, aphp);
                structService.createStruct(parisHopital);

                Struct pole = new Struct("pole adminitsratif", Level.POLE, parisHopital);
                structService.createStruct(pole);

                Set<Speciality> spe_set = new HashSet<>();

                Speciality s = new Speciality("Chirurgie");
                specialityRepository.save(s);
                spe_set.add(s);

                Staff jaid = new Staff("jaid", "BENNI", Instant.now(), "France",
                        "0765467653", "jaid.benni@gmail.com", "RIB", 77000, "Shelle",
                        "rue", "FRANCE", "calendarLink", role, pole, null, spe_set);

                staffService.createStaff(jaid);

	}
}
