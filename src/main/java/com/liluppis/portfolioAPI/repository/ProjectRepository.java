package com.liluppis.portfolioAPI.repository;

import com.liluppis.portfolioAPI.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {

    Optional<Project> findById(String id);

    @Query("{'tags': ?0}")
    List<Project> findByTags(String tag);
}
