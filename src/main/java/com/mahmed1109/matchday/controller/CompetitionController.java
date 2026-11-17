package com.mahmed1109.matchday.controller;
import com.mahmed1109.matchday.model.Competition;
import com.mahmed1109.matchday.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competitions")
public class CompetitionController {
    private final CompetitionService competitionService;


    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable String id) {
        Competition competition = competitionService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(competition);
    }
}
