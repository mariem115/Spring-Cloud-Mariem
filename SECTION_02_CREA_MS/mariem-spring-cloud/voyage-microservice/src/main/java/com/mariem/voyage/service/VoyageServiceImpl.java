package com.mariem.voyage.service;

import com.mariem.voyage.dto.VoyageDto;
import com.mariem.voyage.entities.Voyage;
import com.mariem.voyage.repos.VoyageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VoyageServiceImpl implements VoyageService {

    private VoyageRepository voyageRepository;

    @Override
    public VoyageDto getVoyageById(Long id) {
        Voyage voyage = voyageRepository.findById(id).get();
        return new VoyageDto(
                voyage.getIdvoyage(),
                voyage.getDestination(),
                voyage.getPrix(),
                voyage.getDateDepart(),
                voyage.getDateRetour(),
                voyage.getEmail(),
                voyage.getCodeType()
        );
    }
}
