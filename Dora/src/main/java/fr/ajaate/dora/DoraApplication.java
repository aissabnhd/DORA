package fr.ajaate.dora;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.services.HospitalizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
    @Autowired
    private DMPRepository dmpRepository;

    @Autowired
	private StructRepository structRepository;

	@Autowired
	private HospitalizationServices hospitalizationServices;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		DMP dmp = new DMP("9912345746534253", "Karl", "Marks",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy");


		dmp = dmpRepository.save(dmp);


		Hospitalization hospitalization = new Hospitalization(Instant.now(), Instant.parse("2020-03-01T10:12:35Z"), 13, dmp, null);

		System.out.println(" id hospitalisation : " + hospitalization.getId());
		hospitalizationServices.save(hospitalization);

	}
}
