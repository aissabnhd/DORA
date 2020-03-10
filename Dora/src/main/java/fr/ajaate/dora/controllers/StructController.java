package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.service.StructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Struct")
public class StructController {

    @Autowired
    private StructService structService;

    @PostMapping
    public ResponseEntity<Struct> save(@RequestBody Struct s) {
        Struct newStruct = structService.createStruct(s);
        return new ResponseEntity<>(newStruct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Struct>> findAll() {
        return new ResponseEntity<List<Struct>>(structService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Struct> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Struct>(structService.getOne(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        structService.deleteStruct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
