package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.ActRepository;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.services.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class ActServiceImplementation implements ActService {
    Logger logger = Logger.getLogger(ActServiceImplementation.class.getName());

    @Autowired
    private ActRepository actRepository;

    @Override
    public Act save(Act act) {
        return actRepository.save(act);
    }

    @Override
    public Act update(Act act) {
        if(!actRepository.existsById(act.getId())){
            logger.info("L'acte avec id : " + act.getId() + "  n'existe pas");
            throw new IllegalStateException("L'acte avec l'id " + act.getId() + " n'existe pas");
        }
        logger.info("Le acte id : " + act.getId() + " vient d'étre modifier");
        return actRepository.save(act);
    }

    @Override
    public List<Act> findAll() {
        return actRepository.findAll();
    }

    @Override
    public Optional<Act> findById(Long id) {
        Optional<Act> act = actRepository.findById(id);
        if(!act.isPresent()){
            logger.info("L'acte avec l'id : " + id + " n'existe pas ");
            throw new IllegalArgumentException("L'acte avec l'id : " + id + " n'existe pas");
        }
        logger.info("L'acte avec id " + id + " a été chargé avec succés ");
        return act;
    }

    @Override
    public void deleteById(Long id) {
        if (!actRepository.existsById(id)) {
            logger.info("L'acte avec l'Id : " + id + " n'existe pas");
            throw new IllegalArgumentException("id : " + id + " n'existe pas");
        }
        actRepository.deleteById(id);
        logger.info("L'acte avec l'Id : " + id + "  a été supprimé avec succès");
    }

    @Override
    public Set<Act> findAllByAffectationId(Long affectationId) {
        return actRepository.findAllByAffectationId(affectationId);
    }

    @Override
    public Set<Act> findAllByDate(Instant date) {
        return actRepository.findAllByDate(date);
    }
}
