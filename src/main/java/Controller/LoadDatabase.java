package Controller;

import domain.Pumakatari;
import domain.PumakatariRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PumakatariRepository repository) {
        return args -> {
            repository.save(new Pumakatari("1325 RFG", "Achumani-San Pedro"));
            repository.save(new Pumakatari("2456 UAP", "Irpavi-LLojeta"));
        };
    }
}