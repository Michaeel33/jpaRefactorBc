package com.example.jpaEshop.Service;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Exception.InvalidUserDataException;
import com.example.jpaEshop.Repository.PersonalDataRepository;
import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;
    private static final Logger logger = LoggerFactory.getLogger(PersonalDataService.class);

    @Autowired
    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }


    public PersonalDataEntity savePersonalData(PersonalDataEntity personalData) {

        logger.info("Attempting to save personal data for user: {}", personalData);

        if (personalData.getFirstName() == null || personalData.getFirstName().isEmpty() ||
                personalData.getLastName() == null || personalData.getLastName().isEmpty() ||
                personalData.getUlica() == null || personalData.getUlica().isEmpty() ||
                personalData.getMesto() == null || personalData.getMesto().isEmpty() ||
                personalData.getPsc() == null || personalData.getPsc().isEmpty()) {

            logger.warn("Validation failed: all fields are required to create a new user.");
            throw new InvalidUserDataException("All fields are required to create a new user.");
        }

        PersonalDataEntity savedData = personalDataRepository.save(personalData);
        logger.info("Personal data saved successfully with ID: {}", savedData.getPerId());
        return savedData;
    }

    public List<PersonalDataEntity> findByNameAndSurname(String firstName, String lastName) {
        logger.info("Searching for users with first name: {} and last name: {}", firstName, lastName);
        List<PersonalDataEntity> foundUsers = personalDataRepository.findByFirstNameAndLastName(firstName, lastName);

        if (foundUsers.isEmpty()) {
            logger.warn("No users found with first name: {} and last name: {}", firstName, lastName);
        } else {
            logger.info("Found {} users with first name: {} and last name: {}", foundUsers.size(), firstName, lastName);
        }

        return foundUsers;
    }

    public PersonalDataEntity updatePersonalData(Long id, PersonalDataEntity updatedData) {
        logger.info("Attempting to update personal data for user ID: {}", id);

        Optional<PersonalDataEntity> existingDataOptional = personalDataRepository.findById(id);
        if (existingDataOptional.isPresent()) {
            PersonalDataEntity existingData = existingDataOptional.get();
            existingData.setFirstName(updatedData.getFirstName());
            existingData.setLastName(updatedData.getLastName());
            existingData.setUlica(updatedData.getUlica());
            existingData.setMesto(updatedData.getMesto());
            existingData.setPsc(updatedData.getPsc());

            PersonalDataEntity updatedDataEntity = personalDataRepository.save(existingData);
            logger.info("Personal data for user ID: {} updated successfully", id);
            return updatedDataEntity;
        } else {
            logger.error("PersonalDataEntity with ID {} not found for update", id);
            throw new RuntimeException("PersonalDataEntity with ID " + id + " not found");
        }
    }


}