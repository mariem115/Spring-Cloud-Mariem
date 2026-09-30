package com.mariem.voyage.service;

import com.mariem.voyage.dto.APIResponseDto;
import com.mariem.voyage.dto.UserDto;
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
        UserDto userDto = webClient.get()
                .uri("http://localhost:8082/api/users/" + voyage.getEmail())
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
        */

        // Communication avec Spring Cloud OpenFeign
        UserDto userDto = apiClient.getUserByEmail(voyage.getEmail());

        VoyageDto voyageDto = new VoyageDto(
                voyage.getIdvoyage(),
                voyage.getDestination(),
                voyage.getPrix(),
                voyage.getDateDepart(),
                voyage.getDateRetour(),
                voyage.getEmail(),
                userDto.getUsername()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setVoyageDto(voyageDto);
        apiResponseDto.setUserDto(userDto);

        return apiResponseDto;
    }
}
