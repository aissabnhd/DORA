package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.DocumentRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class DocumentImplementation implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Document save(Document document) {
        try {
            //"./target/public/nomes.txt"
            File file = new File(document.getPath());

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentRepository.save(document);

    }

    @Override
    public Document update(Document document) {
        if(!document.getValidation())
            if(documentRepository.existsById(document.getId()))
                return documentRepository.save(document);
            else
                throw new IllegalStateException("Le document avec l'id " + document.getId() + " n'existe pas ");
            else
                throw new IllegalStateException("Le document avec l'id "+ document.getId() + " est déja validé");

    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getAllByType(DocumentType documentType) {
        return documentRepository.findAllByType(documentType);
    }

    @Override
    public List<Document> getAllByNature(DocumentNature documentNature) {
        return documentRepository.findAllByNature(documentNature);
    }

    @Override
    public List<String> getDocumentContent (String path   )
  {

      String line = "test";
      String content="";
      List<String> lst = new ArrayList<>();
      try {
          FileReader ler = new FileReader(path);
          BufferedReader reader = new BufferedReader(ler);
          while ((line = reader.readLine()) != null) {
             // System.out.println(line);
              lst.add(line);
              //content.concat(line);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
      System.out.println(content);
      return  lst;
  }

    @Override
    public int getNextId(String path) {
        File repertoire = new File(path);
        File[] files=repertoire.listFiles();
        return files.length;
    }

    @Override
    public Optional<Document> getRemarqueOf(Long idDMP) {
        List<Document> lst = getAll();
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getAct().getAffectation().getHospitalization().getDmp().getId() == idDMP && lst.get(i).getType() == DocumentType.NOTES)
                return Optional.of(lst.get(i));

        }
        return Optional.empty();
    }


    @Override
    public String setDocumentContent(String content, String path){
        try {
            //"./target/public/nomes.txt"
            File file = new File(path);

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escreve e fecha arquivo
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return  "ok";
    }



    @Override
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         documentRepository.deleteById(id);
    }

    @Override
    public Document validateDocument(Document document, Long idValidator) {
        if (documentRepository.existsById(document.getId()))
            if(!document.getValidation()){
                document.setValidation(true);
                document.setDateValidation(new Date());
                Optional<Staff> optionalStaff = staffRepository.findById(idValidator);
                if(!optionalStaff.isPresent())
                    throw new IllegalStateException("Le staff avec l'id "+ idValidator + " n'existe pas");
                document.setStaffValidator(optionalStaff.get());
                return document;
            }else
                throw new IllegalStateException("Le document avec l'id "+ document.getId() + " est déja validé");
        else
            throw new IllegalStateException("Le document avec l'id " + document.getId() + " n'existe pas");
    }

    @Override
    public Set<Document> findDocumentsAllByActsId(Long actId) {
        return documentRepository.findAllByActId(actId);
    }


}
