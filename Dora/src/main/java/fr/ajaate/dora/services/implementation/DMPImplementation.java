package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.DMPRepository;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.services.DMPServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;


@Service
public class DMPImplementation implements DMPServices {
    Logger logger = Logger.getLogger(DMPImplementation.class.getName());

    @Autowired
    private DMPRepository dmpRepository;

    @Override
    public DMP save(DMP dmp) {
        if(dmpRepository.existsById(dmp.getId()))
            throw new IllegalArgumentException("Le DMP avec l'id suivant : "+ dmp.getId() +" existe déjà !");
        if(dmpRepository.existsDMPBySocialSecurityNumber(dmp.getSocialSecurityNumber()))
            throw new IllegalArgumentException("Le DMP avec le numéro de sécurité social suivant : "+ dmp.getSocialSecurityNumber() +" existe déjà !");
        return dmpRepository.save(dmp);
    }

    @Override
    public DMP update(DMP dmp) {
        if(!dmpRepository.existsById(dmp.getId())){
            logger.info("Nouveau dmp id : " + dmp.getId() + " vient d'étre crier");
            return dmpRepository.save(dmp);
        }
        logger.info("Le dmp id : " + dmp.getId() + " vient d'étre modifier");
        return dmpRepository.save(dmp);
    }

    @Override
    public List<DMP> findAll() {
        return dmpRepository.findAll();
    }

    @Override
    public Optional<DMP> findById(Long id) {
        Optional<DMP> animal = dmpRepository.findById(id);
        if(!animal.isPresent()){
            logger.info("Le dmp avec l'id : " + id + " n'existe pas ");
           throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        logger.info("Le dmp avec id " + id + " a été chargé avec succés ");
        return animal;
    }

    @Override
    public void deleteById(Long id) {
        if (!dmpRepository.existsById(id)) {
            logger.info("Le dmp avec l'Id : " + id + " n'existe pas");
            throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        dmpRepository.deleteById(id);
        logger.info("Le dmp avec l'Id : " + id + "  a été supprimé avec succès");
    }

    @Override
    public List<DMP> findByLastName(String lastName) {
        return dmpRepository.findAllByLastName(lastName);
    }

    @Override
    public List<DMP> findByFirstName(String firstName) {
        return dmpRepository.findAllByFirsName(firstName);
    }

    @Override
    public Optional<DMP> findBySocialSecurityNumber(String socialSecurityNumber) {
        return dmpRepository.findBySocialSecurityNumber(socialSecurityNumber);
    }

    @Override
    public Set<DMP> findAllByStructId(Long structId) {
        return dmpRepository.findAllByStructId(structId);
    }
}
