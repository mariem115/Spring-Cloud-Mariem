package com.mariem.user;

import com.mariem.user.entities.User;
import com.mariem.user.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			userRepository.save(User.builder()
					.username("mariem")
					.password("1234")
					.email("mariem@gmail.com")
					.role("ADMIN")
					.enabled(true)
					.build());
			userRepository.save(User.builder()
					.username("ahmed")
					.password("1234")
					.email("ahmed@gmail.com")
					.role("CLIENT")
					.enabled(true)
					.build());
		};
	}
}
