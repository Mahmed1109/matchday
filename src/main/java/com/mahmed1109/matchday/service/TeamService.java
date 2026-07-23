package com.mahmed1109.matchday.service;
import com.mahmed1109.matchday.model.Team;
import com.mahmed1109.matchday.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mahmed1109.matchday.exception.TeamNotFoundException;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team findById(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }
}
