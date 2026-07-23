package com.mahmed1109.matchday.service;
import com.mahmed1109.matchday.exception.FollowedTeamNotFoundException;
import com.mahmed1109.matchday.exception.TeamAlreadyFollowedException;
import com.mahmed1109.matchday.exception.TeamNotFoundException;
import com.mahmed1109.matchday.model.FollowedTeam;
import com.mahmed1109.matchday.model.Team;
import com.mahmed1109.matchday.model.User;
import com.mahmed1109.matchday.repository.TeamRepository;
import com.mahmed1109.matchday.repository.FollowTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mahmed1109.matchday.service.UserService;
import com.mahmed1109.matchday.service.TeamService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FollowedTeamService {
    private final FollowTeamRepository followTeamRepository;
    private final TeamRepository teamRepository;
    private final UserService userService;
    private final TeamService teamService;


    public FollowedTeam followTeam(String userId, String teamId) {
        userService.findById(userId);
        teamService.findById(teamId);
        Optional<FollowedTeam> followedTeam =followTeamRepository.findByUserIdAndTeamId(userId,teamId);
        if(followedTeam.isPresent()) {
            throw new TeamAlreadyFollowedException(userId, teamId);
        }
        FollowedTeam newFollowedTeam = new FollowedTeam(null,teamId,userId);
        FollowedTeam savedteam =followTeamRepository.save(newFollowedTeam);
        return savedteam;
    }

    public void unfollowTeam(String userId, String teamId) {
        userService.findById(userId);
        teamService.findById(teamId);
        Optional<FollowedTeam>unfollowedTeam =followTeamRepository.findByUserIdAndTeamId(userId,teamId);
        if(unfollowedTeam.isPresent()) {
            followTeamRepository.delete(unfollowedTeam.get());
        }
        else{
            throw new FollowedTeamNotFoundException(userId, teamId);

        }
    }

    public List<Team> findAllFollowedTeams(String userId) {
        List<Team> teams=new ArrayList<>();
        List<FollowedTeam> followedTeams = followTeamRepository.findByUserId(userId);
        for(FollowedTeam followedTeam:followedTeams){
            teams.add(teamService.findById(followedTeam.getTeamId()));
        }
        return teams;

    }

}
