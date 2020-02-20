package fr.ajaate.dora.controlors;



import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Document")
public class DocumentControllor {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> save(@RequestBody Document document) {
        Document document1 = documentService.save(document);
        return new ResponseEntity<Document>(document1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Document>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                             @RequestParam(name = "size", defaultValue = "10") int size) {
        List<Document> documents = documentService.getAll();
        System.out.println(documents.size());
        return new ResponseEntity<List<Document>>(documentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Document>(documentService.findById(id).get(), HttpStatus.OK);
    }


    @GetMapping("validate/{id}/{idValidator}/{dateValidation}")
    public ResponseEntity<Boolean> validate(Long id , Long idValidator, Instant dateValidation){
        return new ResponseEntity<Boolean>(documentService.validateDocument(id,idValidator,dateValidation), HttpStatus.OK);
    }


    @GetMapping("validate/{id}")
    public ResponseEntity<Boolean> generate(Long id ){
        return new ResponseEntity<Boolean>(documentService.generatePDF(id), HttpStatus.OK);
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        documentService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
