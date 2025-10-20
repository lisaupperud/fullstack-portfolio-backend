package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;

import java.util.Optional;

public interface IProjectService {
    Optional<ProjectCreationDTO> getProject(String id);
    ProjectCreationDTO save(ProjectCreationDTO projectDTO);

}
