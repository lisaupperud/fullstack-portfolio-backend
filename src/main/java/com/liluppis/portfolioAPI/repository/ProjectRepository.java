package com.liluppis.portfolioAPI.repository;

import com.liluppis.portfolioAPI.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class ProjectRepository implements MongoRepository<Project, String> {
}
