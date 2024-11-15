package org.enset.comptemicroservice;

import org.enset.comptemicroservice.entities.Compte;
import org.enset.comptemicroservice.repositries.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompteMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteMicroServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner initData(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null,"ACC123", "USD", 1000.00));
            compteRepository.save(new Compte(null,"ACC124", "EUR", 1000.00));
            compteRepository.save(new Compte(null,"ACC125", "GBP", 1500.00));

            System.out.println("Initial data loaded into the Compte table.");
        };
    }
}
