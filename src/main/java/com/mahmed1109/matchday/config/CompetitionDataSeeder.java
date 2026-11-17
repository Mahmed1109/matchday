package com.mahmed1109.matchday.config;
import com.mahmed1109.matchday.model.Competition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mahmed1109.matchday.repository.CompetitionRepository;
import java.util.List;

@Component
@RequiredArgsConstructor

public class CompetitionDataSeeder implements CommandLineRunner {
    private final CompetitionRepository competitionRepository;

    @Override
    public void run(String... args) {
        if(competitionRepository.count()>0){
            return;
        }
        List<Competition> competitions = List.of(
                new Competition(null, "Premier League", "PL", "https://crests.football-data.org/PL.png"),
                new Competition(null, "UEFA Champions League", "CL", "https://crests.football-data.org/CL.png"),
                new Competition(null, "La Liga", "PD", "https://crests.football-data.org/PD.png"),
                new Competition(null, "Bundesliga", "BL1", "https://crests.football-data.org/BL1.png"),
                new Competition(null, "Serie A", "SA", "https://crests.football-data.org/SA.png"),
                new Competition(null, "Ligue 1", "FL1", "https://crests.football-data.org/FL1.png")
        );
        competitionRepository.saveAll(competitions);
    }
}
