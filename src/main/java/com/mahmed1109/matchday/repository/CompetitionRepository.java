package com.mahmed1109.matchday.repository;

import com.mahmed1109.matchday.model.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition,String> {
}
