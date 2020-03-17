package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.HospitalizationRepository;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.services.HospitalizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class HospitalizationServicesImplementation implements HospitalizationServices {
    Logger logger = Logger.getLogger(HospitalizationServicesImplementation.class.getName());

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    @Override
    public Hospitalization save(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    @Override
    public Hospitalization update(Hospitalization hospitalization) {
        if(!hospitalizationRepository.existsById(hospitalization.getId())){
            logger.info("Nouveau hospitalisation id : " + hospitalization.getId() + " vient d'étre crier");
            return hospitalizationRepository.save(hospitalization);
        }
        logger.info("Le hospitalisation id : " + hospitalization.getId() + " vient d'étre modifier");
        return hospitalizationRepository.save(hospitalization);
    }

    @Override
    public List<Hospitalization> findAll() {
        logger.info("chercher les toutes les  hospitalisations");
        return hospitalizationRepository.findAll();
    }

    @Override
    public Optional<Hospitalization> findById(Long id) {
        Optional<Hospitalization> hospitalization = hospitalizationRepository.findById(id);
        if(!hospitalization.isPresent()){
            logger.info("Le hospitalisation avec l'id : " + id + " n'existe pas ");
            throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        logger.info("Le hospitalisation avec id " + id + " a été chargé avec succés ");
        return hospitalization;
    }

    @Override
    public void deleteById(Long id) {
        if (!hospitalizationRepository.existsById(id)) {
            logger.info("Le hospitalization avec l'Id : " + id + " n'existe pas");
            throw new IllegalArgumentException("id : " + id + " l'id n'existe pas");
        }
        hospitalizationRepository.deleteById(id);
        logger.info("Le hospitalization avec l'Id : " + id + "  a été supprimé avec succès");
    }

    @Override
    public Set<Hospitalization> findAllByDateHospitalization(Instant dateHospitalization) {
        return hospitalizationRepository.findAllByDateHospitalization(dateHospitalization);
    }

    @Override
    public Set<Hospitalization> findAllByDmpId(Long dmpId) {
        return hospitalizationRepository.findAllByDmpId(dmpId);
    }

    @Override
    public Set<Hospitalization> findAllByStructId(Long structId) {
        return hospitalizationRepository.findAllByStructId(structId);
    }

    @Override
    public Optional<Hospitalization> findCurrentHospitalisation(Long idDMP) {
        List<Hospitalization> lst = findAll();
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getDateEndHospitalization() == null && lst.get(i).getDmp().getId() == idDMP)
                return Optional.of(lst.get(i));
        }
        return Optional.empty();
    }

}
