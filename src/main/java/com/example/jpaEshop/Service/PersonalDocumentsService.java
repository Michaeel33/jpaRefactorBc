package com.example.jpaEshop.Service;

import com.example.jpaEshop.Entity.PersonalDocumentsEntity;
import com.example.jpaEshop.Repository.PersonalDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonalDocumentsService {

    @Autowired
    private PersonalDocumentsRepository repository;

    public List<PersonalDocumentsEntity> findByCustomerCard(String customerCard) {
        return repository.findByCustomerCard(customerCard);
    }

    public PersonalDocumentsEntity createPersonalDocument(PersonalDocumentsEntity entity) {
        return repository.save(entity);
    }
}