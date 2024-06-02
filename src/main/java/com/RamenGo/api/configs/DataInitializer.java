package com.RamenGo.api.configs;
import com.RamenGo.api.models.Broth;
import com.RamenGo.api.models.Protein;
import com.RamenGo.api.repositories.BrothRepository;
import com.RamenGo.api.repositories.ProteinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

  @Bean
  CommandLineRunner initDatabase(BrothRepository brothRepository, ProteinRepository proteinRepository) {
    return args -> {
      brothRepository.save(new Broth("1", "https://tech.redventures.com.br/icons/salt/inactive.svg",
          "https://tech.redventures.com.br/icons/salt/active.svg",
          "Salt", "Simple like the seawater, nothing more", 10));

      proteinRepository.save(new Protein("1", "https://tech.redventures.com.br/icons/pork/inactive.svg",
          "https://tech.redventures.com.br/icons/pork/active.svg",
          "Chasu", "A sliced flavourful pork meat with a selection of season vegetables.", 10));
    };
  }
}
