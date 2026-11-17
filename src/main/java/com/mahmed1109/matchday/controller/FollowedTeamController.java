package com.mahmed1109.matchday.controller;
import com.mahmed1109.matchday.model.FollowedTeam;
import com.mahmed1109.matchday.service.FollowedTeamService;
import com.mahmed1109.matchday.model.Team;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followed-teams")
@RequiredArgsConstructor

public class FollowedTeamController {
    private final FollowedTeamService followedTeamService;

    @PostMapping("/{userId}/{teamId}")
    public ResponseEntity<FollowedTeam> followTeam(@PathVariable String userId, @PathVariable String teamId) {
        FollowedTeam newfollowedTeam = followedTeamService.followTeam(userId, teamId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newfollowedTeam);

    }

    @DeleteMapping("/{userId}/{teamId}")
    public ResponseEntity<String> unfollowTeam(@PathVariable String userId, @PathVariable String teamId) {
        followedTeamService.unfollowTeam(userId, teamId);
        return ResponseEntity.status(HttpStatus.OK).body("Followed Team with id" + teamId + " has been deleted");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Team>> getFollowedTeam(@PathVariable String userId) {
        List<Team>allTeams=followedTeamService.findAllFollowedTeams(userId);
        return ResponseEntity.status(HttpStatus.OK).body(allTeams);

    }
}
