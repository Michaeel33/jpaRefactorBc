package com.example.jpaEshop.Repository;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalDataEntity, Long> {

    List<PersonalDataEntity> findByFirstNameAndLastName(String firstName, String lastName);


}
