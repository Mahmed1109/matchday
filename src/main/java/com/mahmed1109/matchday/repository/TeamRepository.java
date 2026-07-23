package com.mahmed1109.matchday.repository;

import com.mahmed1109.matchday.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team,String> {
}
