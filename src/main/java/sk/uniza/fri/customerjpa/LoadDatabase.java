package sk.uniza.fri.customerjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            log.info("Preloading... " +
                    repository.save(
                            new Customer("Peter", "Peteraj",
                                    Gender.MALE, LocalDate.of(2000, 11, 8))
                    )
            );

            log.info("Preloading... " +
                    repository.save(
                            new Customer("Marek", "Lipno",
                                    Gender.MALE, LocalDate.of(1999, 7, 9))
                    )
            );

            log.info("Preloading... " +
                    repository.save(
                            new Customer("Alex", "Materaj",
                                    Gender.MALE, LocalDate.of(2000, 4, 26))
                    )
            );

            log.info("Preloading... " +
                    repository.save(
                            new Customer("Ivan", "Pekny",
                                    Gender.MALE, LocalDate.of(2000, 9, 29))
                    )
            );

        };
    }


}
