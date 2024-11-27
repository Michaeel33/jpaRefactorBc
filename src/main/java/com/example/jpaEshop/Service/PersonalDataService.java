package com.example.jpaEshop.Service;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Repository.PersonalDataRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    @Autowired
    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public PersonalDataEntity savePersonalData(PersonalDataEntity personalData) {
        return personalDataRepository.save(personalData);
    }

    public List<PersonalDataEntity> findByNameAndSurname(String firstName, String lastName) {
        return personalDataRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public PersonalDataEntity updatePersonalData(Long id, PersonalDataEntity updatedData) {
        Optional<PersonalDataEntity> existingDataOptional = personalDataRepository.findById(id);
        if (existingDataOptional.isPresent()) {
            PersonalDataEntity existingData = existingDataOptional.get();
            existingData.setFirstName(updatedData.getFirstName());
            existingData.setLastName(updatedData.getLastName());
            existingData.setUlica(updatedData.getUlica());
            existingData.setMesto(updatedData.getMesto());
            existingData.setPsc(updatedData.getPsc());
            return personalDataRepository.save(existingData);
        } else {
            throw new RuntimeException("PersonalDataEntity with ID " + id + " not found");
        }
    }


}