package com.example.jpaEshop.Controller;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Exception.UserNotFoundException;
import com.example.jpaEshop.Service.PersonalDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaldata")
public class PersonalDataController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalDataController.class);
    private final PersonalDataService personalDataService;

    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonalDataEntity> createPersonalData(@RequestBody PersonalDataEntity personalData) {
        logger.info("Received POST request to create personal data: {}", personalData);

        PersonalDataEntity savedData = personalDataService.savePersonalData(personalData);

        logger.info("Successfully created personal data: {}", savedData);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonalDataEntity>> findByNameAndSurname(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        logger.info("GET REQUEST: search user firstName: {} and lastName: {}", firstName, lastName);

        List<PersonalDataEntity> users = personalDataService.findByNameAndSurname(firstName, lastName);

        if (users.isEmpty()) {
            logger.warn("RESPONSE: No users found firstName: {} and lastName: {}", firstName, lastName);
            throw new UserNotFoundException("No users found with name: " + firstName + " and surname: " + lastName);
        }

        logger.info("Found {} users for firstName: {} and lastName: {}", users.size(), firstName, lastName);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalDataEntity> updatePersonalData(
            @PathVariable Long id,
            @RequestBody PersonalDataEntity updatedData) {
        logger.info("Received PUT request to update personal data for ID: {}, with data: {}", id, updatedData);

        PersonalDataEntity updatedUser = personalDataService.updatePersonalData(id, updatedData);

        logger.info("Successfully updated personal data for ID: {}", id);
        return ResponseEntity.ok(updatedUser);
    }

}
