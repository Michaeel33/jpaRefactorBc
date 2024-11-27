package com.example.jpaEshop.Repository;

import com.example.jpaEshop.Entity.PersonalDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonalDocumentsRepository extends JpaRepository<PersonalDocumentsEntity, Long> {
    List<PersonalDocumentsEntity> findByCustomerCard(String customerCard);
}
