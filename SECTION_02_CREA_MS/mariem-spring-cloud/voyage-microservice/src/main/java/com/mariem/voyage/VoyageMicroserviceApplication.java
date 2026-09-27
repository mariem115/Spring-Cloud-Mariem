package com.mariem.voyage;

import com.mariem.voyage.entities.Voyage;
import com.mariem.voyage.repos.VoyageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class VoyageMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoyageMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VoyageRepository voyageRepository) {
		return args -> {
			voyageRepository.save(Voyage.builder()
					.destination("Barcelone")
					.prix(1200.0)
					.dateDepart(LocalDate.of(2027, 7, 10))
					.dateRetour(LocalDate.of(2027, 7, 20))
					.email("mariem@gmail.com")
					.codeType("CRU")
					.build());
			voyageRepository.save(Voyage.builder()
					.destination("Istanbul")
					.prix(950.0)
					.dateDepart(LocalDate.of(2027, 8, 5))
					.dateRetour(LocalDate.of(2027, 8, 15))
					.email("ahmed@gmail.com")
					.codeType("CIR")
					.build());
			voyageRepository.save(Voyage.builder()
					.destination("Djerba")
					.prix(450.0)
					.dateDepart(LocalDate.of(2027, 6, 1))
					.dateRetour(LocalDate.of(2027, 6, 7))
					.email("mariem@gmail.com")
					.codeType("SEJ")
					.build());
		};
	}
}
