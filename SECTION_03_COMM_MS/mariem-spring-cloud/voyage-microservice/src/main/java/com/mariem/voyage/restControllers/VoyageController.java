package com.mariem.voyage.restControllers;

import com.mariem.voyage.dto.APIResponseDto;
import com.mariem.voyage.service.VoyageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voyages")
@AllArgsConstructor
public class VoyageController {

    private VoyageService voyageService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getVoyageById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(
                voyageService.getVoyageById(id),
                HttpStatus.OK);
    }
}
