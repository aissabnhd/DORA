package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.AffectationRepository;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class AffectationServicesImplementation implements AffectationServices {
    Logger logger = Logger.getLogger(AffectationServicesImplementation.class.getName());

    @Autowired
    private AffectationRepository affectationRepository;

    @Override
    public Affectation save(Affectation affectation) {
        return affectationRepository.save(affectation);
    }

    @Override
    public Affectation update(Affectation affectation) {
        if(!affectationRepository.existsById(affectation.getId())){
            logger.info("L'affectation id : " + affectation.getId() + "  n'existe pas");
            throw new IllegalStateException("L'affectation avec l'id " + affectation.getId() + " n'existe pas");
        }
        logger.info("Le affectation id : " + affectation.getId() + " vient d'étre modifier");
        return affectationRepository.save(affectation);
    }

    @Override
    public List<Affectation> findAll() {
        logger.info("chercher les toutes les  affectations");
        return affectationRepository.findAll();
    }

    @Override
    public Optional<Affectation> findById(Long id) {
        Optional<Affectation> affectation = affectationRepository.findById(id);
        if(!affectation.isPresent()){
            logger.info("Le affectation avec l'id : " + id + " n'existe pas ");
            throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        logger.info("Le affectation avec id " + id + " a été chargé avec succés ");
        return affectation;
    }

    @Override
    public void deleteById(Long id) {
        if (!affectationRepository.existsById(id)) {
            logger.info("Le affectation avec l'Id : " + id + " n'existe pas");
            throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        affectationRepository.deleteById(id);
        logger.info("Le affectation avec l'Id : " + id + "  a été supprimé avec succès");
    }

    /*
    @Override
    public Set<Affectation> findAllByDateAffectation(Instant dateAffectation) {
        return affectationRepository.findAllByDateAffectation(dateAffectation);
    }
    */

    @Override
    public Set<Affectation> findAllByHospitalization(Long hospitalizationId) {
        return affectationRepository.findAllByHospitalizationId(hospitalizationId);
    }

    @Override
    public Set<Affectation> findAllByDateAffectation(Date dateAffectation) {
        return affectationRepository.findAllByDateAffectation(dateAffectation);
    }


}
