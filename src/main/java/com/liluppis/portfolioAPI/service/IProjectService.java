package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.dto.ProjectResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    // GET single project by ID
    Optional<ProjectResponseDTO> getProject(String id);

    // GET List of ALL projects
    List<ProjectResponseDTO> getAllProjects();

    // GET List of projects by TAGS
    List<ProjectResponseDTO> getProjectsByTags(String tag);

    // POST new project (SAVE)
    ProjectResponseDTO saveProject(ProjectCreationDTO projectDTO);

    // PUT existing project
    Optional<ProjectResponseDTO> updateProject(String id, ProjectCreationDTO projectDTO);

    // DELETE project by ID
    Optional<Void> deleteProject(String id);


}
