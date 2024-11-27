package com.example.jpaEshop.Entity;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personaldocuments")
public class PersonalDocumentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perid")
    private Long perId;

    @Column(name = "obcianskypreukaz", nullable = false)
    private String customerCard;

    @Column(name = "stat", nullable = false)
    private int stat;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;
}
