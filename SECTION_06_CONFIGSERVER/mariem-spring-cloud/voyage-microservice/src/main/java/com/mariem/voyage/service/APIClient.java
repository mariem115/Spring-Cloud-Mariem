package com.mariem.voyage.service;

import com.mariem.voyage.dto.AgenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(url = "http://localhost:8082", value = "AGENCE")
@FeignClient(name = "AGENCE")
public interface APIClient {

    @GetMapping("api/agences/{code}")
    AgenceDto getAgenceByCode(@PathVariable("code") String code);
}
