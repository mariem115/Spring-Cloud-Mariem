package com.mariem.agence.restControllers;

import com.mariem.agence.dto.AgenceDto;
import com.mariem.agence.service.AgenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agences")
@AllArgsConstructor
public class AgenceController {

    private AgenceService agenceService;

    @GetMapping("{code}")
    public ResponseEntity<AgenceDto> getAgenceByCode(@PathVariable("code") String code) {
        return new ResponseEntity<AgenceDto>(
                agenceService.getAgenceByCode(code),
                HttpStatus.OK);
    }
}