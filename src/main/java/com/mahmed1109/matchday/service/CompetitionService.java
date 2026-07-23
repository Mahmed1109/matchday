package com.mahmed1109.matchday.service;
import com.mahmed1109.matchday.exception.CompetitionNotFoundException;
import com.mahmed1109.matchday.model.Competition;
import com.mahmed1109.matchday.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;


    public Competition findById(String id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new CompetitionNotFoundException(id));

    }

}
