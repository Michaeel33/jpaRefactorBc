package com.example.jpaEshop.Repository;

import com.example.jpaEshop.Entity.PersonalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalDataEntity, Long> {


}
