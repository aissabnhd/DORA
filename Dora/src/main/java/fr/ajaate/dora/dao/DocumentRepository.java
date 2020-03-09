package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.DMP;


import fr.ajaate.dora.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    boolean existsById(Long aLong);
    Set<Document> findAllByActId(Long actId);
    List<Document> findAllByNature();
    List<Document> findAllByType();
}
