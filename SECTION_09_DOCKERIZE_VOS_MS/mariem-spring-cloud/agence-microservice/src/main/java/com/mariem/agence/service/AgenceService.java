package com.mariem.agence.service;

import com.mariem.agence.dto.AgenceDto;

public interface AgenceService {

    AgenceDto getAgenceByCode(String code);
}