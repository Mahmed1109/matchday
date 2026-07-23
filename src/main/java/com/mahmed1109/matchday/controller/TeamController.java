package com.mahmed1109.matchday.controller;
import com.mahmed1109.matchday.model.Team;
import com.mahmed1109.matchday.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/team")
@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable String id) {
        Team team = teamService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(team);
    }

}
