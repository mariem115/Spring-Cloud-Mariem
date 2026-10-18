package com.mariem.agence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDto {

    private Long idAgence;

    private String code;

    private String nom;

    private String adresse;

    private String telephone;

    private String email;
}