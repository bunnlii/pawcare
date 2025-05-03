package com.Pawcare;

import com.pawcare.entity.Service;
import com.pawcare.repository.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(ServiceRepository serviceRepository) {
		return args -> {
			serviceRepository.save(new Service("grooming", 40, "Grooming your pets.", "/images/pet_groom.svg"));
			serviceRepository.save(new Service("vet", 100, "Full vet services.", "/images/pet_vet.svg"));
			serviceRepository.save(new Service("sitting", 20, "Pet sitting services.", "/images/pet_sit.svg"));
			serviceRepository.save(new Service("walking", 15, "Dog walking services.", "/images/pet_walk.svg"));
			serviceRepository.save(new Service("training", 25, "Pet training.", "/images/pet_train.svg"));
			serviceRepository.save(new Service("adoption", 200, "Adoption support.", "/images/pet_adopt.svg"));
		};
	}
}
