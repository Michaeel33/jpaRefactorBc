package com.example.jpaEshop.Controller;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Exception.UserNotFoundException;
import com.example.jpaEshop.Service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaldata")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonalDataEntity> createPersonalData(@RequestBody PersonalDataEntity personalData) {
        PersonalDataEntity savedData = personalDataService.savePersonalData(personalData);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonalDataEntity>> findByNameAndSurname(@RequestParam String firstName, @RequestParam String lastName) {
        List<PersonalDataEntity> users = personalDataService.findByNameAndSurname(firstName, lastName);
        
        if (users.isEmpty()) {
            throw new UserNotFoundException("No user found with name: " + firstName + " and surname: " + lastName);
        }

        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalDataEntity> updatePersonalData(@PathVariable Long id, @RequestBody PersonalDataEntity updatedData) {
        PersonalDataEntity updatedUser = personalDataService.updatePersonalData(id, updatedData);
        return ResponseEntity.ok(updatedUser);
    }

}
