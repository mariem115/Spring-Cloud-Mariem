package com.mariem.voyage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idvoyage;

    private String destination;

    private Double prix;

    private LocalDate dateDepart;

    private LocalDate dateRetour;

    private String email;
}
