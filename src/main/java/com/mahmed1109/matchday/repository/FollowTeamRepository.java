package com.mahmed1109.matchday.repository;

import com.mahmed1109.matchday.model.FollowedTeam;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FollowTeamRepository extends MongoRepository<FollowedTeam,String> {
    Optional<FollowedTeam> findByUserIdAndTeamId(String userId, String teamId);
    List<FollowedTeam> findByUserId(String userId);
}
