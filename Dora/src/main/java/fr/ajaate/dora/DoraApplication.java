package fr.ajaate.dora;

import fr.ajaate.dora.dao.ActRepository;
import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.dao.DocumentRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.enumeration.DocumentType;

import fr.ajaate.dora.service.DocumentService;
import org.hibernate.dialect.function.StaticPrecisionFspTimestampFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@SpringBootApplication
public class DoraApplication implements CommandLineRunner {
    @Autowired
    private DMPRepository dmpRepository;

    @Autowired
	DocumentRepository documentRepository;

	@Autowired
	ActRepository actRepository;

	@Autowired
	StaffRepository staffRepository;

    public static void main(String[] args) {
        SpringApplication.run(DoraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Instant instant = Instant.now();
		Act acte = new  Act ("act",instant);
		dmpRepository.save(new DMP("9912345746534253", "Karl", "Marks",
				Instant.parse("1993-01-01T10:12:35Z"), "France", "+33784563452",
				"k.marks@gmail.com", 75001, "Paris", "Boulevard saint-denis",
				"France", "allergy"));
				Staff staff=new Staff("hamid","macron",instant,"franco-algerien","0000",
						"hamid-macron@gmail.com","IBAN-BIC",93,"saint-denis","je sais pas ",
						"FR","hisAgenda");
				actRepository.save(acte);
				staffRepository.save(staff);
		Document d= new Document( "pdf", "pdf", instant,false, instant, "/DMPS",acte,staff);
		documentRepository.save(d);
		System.out.println(documentRepository.findAll());

    }


}
