package com.example.jpaEshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personaldata")
public class PersonalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "mesto")
    private String mesto;

    @Column(name = "psc")
    private String psc;

}