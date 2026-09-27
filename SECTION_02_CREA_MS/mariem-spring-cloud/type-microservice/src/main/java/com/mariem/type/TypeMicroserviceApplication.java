package com.mariem.type;

import com.mariem.type.entities.Type;
import com.mariem.type.repos.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TypeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypeMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TypeRepository typeRepository) {
		return args -> {
			typeRepository.save(Type.builder()
					.nomType("Croisiere")
					.codeType("CRU")
					.build());
			typeRepository.save(Type.builder()
					.nomType("Circuit organise")
					.codeType("CIR")
					.build());
			typeRepository.save(Type.builder()
					.nomType("Sejour balneaire")
					.codeType("SEJ")
					.build());
		};
	}
}
