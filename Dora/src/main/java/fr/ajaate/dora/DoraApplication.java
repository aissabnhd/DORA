package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Set;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
	@Autowired
	private DMPServices dmpServices;

	@Autowired
	private HospitalizationServices hospitalizationServices;

	@Autowired
	private StructRepository structRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		DMP dmp = new DMP("9912345746534253", "Karl", "Marks",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");
		DMP dmp2 = new DMP("9912345746584243", "Emile", "Zola",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"e.zola@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");

		DMP dmp3 = new DMP("9912345746584263", "sara", "sara",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
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
		Set<DMP> dmpSet = dmpServices.findAllByStructId(struct.getId());
		System.out.println(dmpSet);
	}
}
