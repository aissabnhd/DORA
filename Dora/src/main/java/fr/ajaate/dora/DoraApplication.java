package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.entities.*;
import fr.ajaate.dora.entities.enumeration.Level;
import fr.ajaate.dora.entities.enumeration.RoleName;
import fr.ajaate.dora.repository.SpecialityRepository;
import fr.ajaate.dora.repository.StaffRepository;
import fr.ajaate.dora.repository.StructRepository;
import fr.ajaate.dora.service.StaffService;
import fr.ajaate.dora.service.StructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
    @Autowired
    private StructRepository structRepository;

    @Autowired
	private StaffRepository staffRepository;

    @Autowired
	private SpecialityRepository specialityRepository;

    @Autowired
	private StructService structService;

    @Autowired
	private StaffService staffService;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		staffRepository.deleteAll();
		structRepository.deleteAll();
		specialityRepository.deleteAll();
		Set<Speciality> spe_set = new HashSet<>();

		Speciality sp1 =  new Speciality("Neurologie");
		specialityRepository.save(sp1);
		Speciality s = new Speciality( "Chirurgie");
		specialityRepository.save(s);
		spe_set.add(s);


		System.out.println("Create APHP\n");
		Struct s1 = structService.createStruct(new Struct("APHP", Level.APHP, null));

		Staff st1 = staffService.createStaff(new Staff("President", s1, spe_set, null));

		System.out.println(structService.getStructResponsible(s1));
		structService.updateResponsible(s1, st1);
		System.out.println(structService.getStructResponsible(s1));


		/*Struct s2 = structService.createStruct(new Struct("HOPITAL PARIS", Level.HOSPITAL, 77410, "Paris", "20 rue des champs", "France", sp1, null, s1));

		Staff st2 = staffService.createStaff(new Staff("President", null, spe_set, null));

		structService.updateResponsible(s2, st2);

		 */

/*
		structService.updateResponsible(s1, st2);

		Struct s2 = new Struct("HOPITAL PARIS", Level.HOSPITAL, s1);
		structService.createStruct(s2);

		Staff st3 = new Staff("Boss de Paris", s2, spe_set);
		staffService.createStaff(st3);

		structService.updateResponsible(s2, st3);

		Struct s3 = new Struct("KREMLIN BICETRE", Level.HOSPITAL, s1);
		structService.createStruct(s3);

		Staff st = new Staff("Nium", s3, spe_set);
		staffService.createStaff(st);

		Struct tmp = new Struct("Unité de Soin", Level.CARE_UNIT, s1);
		structService.createStruct(tmp);


		System.out.println(structService.deleteStruct(tmp.getId()));



		/*Struct s3 = new Struct("UF", 5, s2);
		structService.createStruct(s3);

		Struct s4 = new Struct("UNKNOWN", 1, s3);
		structService.createStruct(s4);






		List<Struct> lst6 = structService.getAll();
		System.out.println(lst6.size());
		for(Struct it : lst6) {
			System.out.println(it.toString());
		}
		*/

	}
}
