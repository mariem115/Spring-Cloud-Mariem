package com.mariem.agence;

import com.mariem.agence.entities.Agence;
import com.mariem.agence.repos.AgenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgenceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AgenceRepository agenceRepository) {
		return args -> {
			agenceRepository.save(Agence.builder()
					.code("AG001")
					.nom("Agence Tunis Centre")
					.adresse("Avenue Habib Bourguiba, Tunis")
					.telephone("71000001")
					.email("tunis@agence.tn")
					.build());
			agenceRepository.save(Agence.builder()
					.code("AG002")
					.nom("Agence Sousse")
					.adresse("Rue de la Plage, Sousse")
					.telephone("73000002")
					.email("sousse@agence.tn")
					.build());
		};
	}
}