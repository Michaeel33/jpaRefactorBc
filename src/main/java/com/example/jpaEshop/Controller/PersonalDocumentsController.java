package com.example.jpaEshop.Controller;

import com.example.jpaEshop.Entity.PersonalDocumentsEntity;
import com.example.jpaEshop.Service.PersonalDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaldocuments")
public class PersonalDocumentsController {

    @Autowired
    private PersonalDocumentsService service;

    @GetMapping("/search")
    public ResponseEntity<List<PersonalDocumentsEntity>> findByCustomerCard(@RequestParam String customerCard) {
        List<PersonalDocumentsEntity> documents = service.findByCustomerCard(customerCard);
        if (documents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/create")
    public ResponseEntity<PersonalDocumentsEntity> createPersonalDocument(@RequestBody PersonalDocumentsEntity entity) {
        PersonalDocumentsEntity createdEntity = service.createPersonalDocument(entity);
        return ResponseEntity.ok(createdEntity);
    }
}