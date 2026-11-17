package com.mahmed1109.matchday.config;
import com.mahmed1109.matchday.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mahmed1109.matchday.repository.TeamRepository;
import java.util.List;


@Component
@RequiredArgsConstructor
public class TeamDataSeeder implements CommandLineRunner {
    private final TeamRepository teamRepository;

    @Override
    public void run(String... args) {
        if(teamRepository.count()>0){
            return;
        }
        List<Team> teams = List.of(
                new Team(null, "Arsenal FC", "Arsenal", "https://crests.football-data.org/57.png"),
                new Team(null, "Chelsea FC", "Chelsea", "https://crests.football-data.org/61.png"),
                new Team(null, "Liverpool FC", "Liverpool", "https://crests.football-data.org/64.png"),
                new Team(null, "Manchester City FC", "Man City", "https://crests.football-data.org/65.png"),
                new Team(null, "Manchester United FC", "Man United", "https://crests.football-data.org/66.png")
        );
        teamRepository.saveAll(teams);
    }
}
