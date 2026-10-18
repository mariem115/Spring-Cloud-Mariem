package com.mariem.agence.service;

import com.mariem.agence.dto.AgenceDto;
import com.mariem.agence.entities.Agence;
import com.mariem.agence.repos.AgenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AgenceServiceImpl implements AgenceService {

    private AgenceRepository agenceRepository;

    @Override
    public AgenceDto getAgenceByCode(String code) {
        Agence agence = agenceRepository.findByCode(code);
        return new AgenceDto(
                agence.getIdAgence(),
                agence.getCode(),
                agence.getNom(),
                agence.getAdresse(),
                agence.getTelephone(),
                agence.getEmail()
        );
    }
}