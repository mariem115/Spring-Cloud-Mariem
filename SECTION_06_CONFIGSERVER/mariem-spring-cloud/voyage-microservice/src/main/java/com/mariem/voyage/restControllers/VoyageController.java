package com.mariem.voyage.restControllers;

import com.mariem.voyage.config.Configuration;
import com.mariem.voyage.dto.APIResponseDto;
import com.mariem.voyage.service.VoyageService;
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
@RequestMapping("/api/voyages")
public class VoyageController {

    private VoyageService voyageService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    Configuration configuration;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getVoyageById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(
                voyageService.getVoyageById(id),
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
