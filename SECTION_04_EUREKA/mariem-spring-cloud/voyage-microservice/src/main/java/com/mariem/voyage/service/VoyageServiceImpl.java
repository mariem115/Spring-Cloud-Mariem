package com.mariem.voyage.service;

import com.mariem.voyage.dto.APIResponseDto;
import com.mariem.voyage.dto.AgenceDto;
import com.mariem.voyage.dto.VoyageDto;
import com.mariem.voyage.entities.Voyage;
import com.mariem.voyage.repos.VoyageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class VoyageServiceImpl implements VoyageService {

    private VoyageRepository voyageRepository;

    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public APIResponseDto getVoyageById(Long id) {
        Voyage voyage = voyageRepository.findById(id).get();

        // Communication avec WebClient
        /*
        AgenceDto agenceDto = webClient.get()
                .uri("http://localhost:8082/api/agences/" + voyage.getCodeAgence())
                .retrieve()
                .bodyToMono(AgenceDto.class)
                .block();
        */

        // Communication avec Spring Cloud OpenFeign
        AgenceDto agenceDto = apiClient.getAgenceByCode(voyage.getCodeAgence());

        VoyageDto voyageDto = new VoyageDto(
                voyage.getIdvoyage(),
                voyage.getDestination(),
                voyage.getPrix(),
                voyage.getDateDepart(),
                voyage.getDateRetour(),
                voyage.getCodeAgence(),
                agenceDto.getNom()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setVoyageDto(voyageDto);
        apiResponseDto.setAgenceDto(agenceDto);

        return apiResponseDto;
    }
}
