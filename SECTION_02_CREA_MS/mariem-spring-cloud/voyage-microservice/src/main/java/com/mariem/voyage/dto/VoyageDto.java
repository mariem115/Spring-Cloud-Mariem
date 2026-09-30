package com.mariem.voyage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDto {

    private Long idvoyage;

    private String destination;

    private Double prix;

    private LocalDate dateDepart;

    private LocalDate dateRetour;

    private String email;
}
