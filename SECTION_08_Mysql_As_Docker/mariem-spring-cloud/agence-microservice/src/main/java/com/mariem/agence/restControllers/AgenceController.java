package com.mariem.agence.restControllers;

import com.mariem.agence.config.Configuration;
import com.mariem.agence.dto.AgenceDto;
import com.mariem.agence.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private AgenceService agenceService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    Configuration configuration;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping("{code}")
    public ResponseEntity<AgenceDto> getAgenceByCode(@PathVariable("code") String code) {
        return new ResponseEntity<AgenceDto>(
                agenceService.getAgenceByCode(code),
                HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}