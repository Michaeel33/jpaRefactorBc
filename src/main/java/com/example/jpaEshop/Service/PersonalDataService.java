package com.example.jpaEshop.Service;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import com.example.jpaEshop.Repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}