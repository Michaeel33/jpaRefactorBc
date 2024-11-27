package com.example.jpaEshop.Controller;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personal-data")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @PostMapping
    public ResponseEntity<PersonalDataEntity> createPersonalData(@RequestBody PersonalDataEntity personalData) {
        PersonalDataEntity savedData = personalDataService.savePersonalData(personalData);
        return ResponseEntity.ok(savedData);
    }
}
