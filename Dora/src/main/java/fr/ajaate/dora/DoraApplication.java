package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.*;
import fr.ajaate.dora.services.ActService;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import fr.ajaate.dora.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.Instant;

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

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
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


		Struct struct = structRepository.save(new Struct("Val De grace", 2, 1,
				"Genève", "10 rue de La passerelle", "Suisse"));
		Struct struct2 = structRepository.save(new Struct("Salpêtrière", 2, 1,
				"Paris", "10 rue de La passerelle", "France"));

		Hospitalization hospitalization = hospitalizationServices.save(new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"),
				13, dmp, struct));
		Hospitalization hospitalization1 = hospitalizationServices.save(new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"),
				14, dmp, struct));
		Hospitalization hospitalization3 = hospitalizationServices.save(new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"),
				14, dmp3, struct2));

		Affectation affectation = affectationServices.save(new Affectation(Instant.parse("1993-01-01T10:12:35Z"), Instant.parse("1993-01-01T10:12:35Z"), hospitalization, struct));

		Staff staff = staffRepository.save(new Staff("john", "john", Instant.now(), "Algérienne",
				"0786545676", "john@gmail.com", "ribsdghfgjhjk", 75000, "Paris", "Boulevard de Rivolet", "FRANCE", ""));

		Act act = actService.save(new Act("scanner", Instant.now(), affectation, staff));

    }
}
