package com.mariem.voyage.service;

import com.mariem.voyage.dto.APIResponseDto;

public interface VoyageService {

    APIResponseDto getVoyageById(Long id);
}
