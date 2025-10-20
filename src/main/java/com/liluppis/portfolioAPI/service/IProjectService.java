package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.dto.ProjectResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    Optional<ProjectResponseDTO> getProject(String id);
    List<ProjectResponseDTO> getAllProjects();
    List<ProjectResponseDTO> getProjectsByTags(List<String> tags);
    ProjectCreationDTO saveProject(ProjectCreationDTO projectDTO);
    Optional<ProjectCreationDTO> updateProject(String id, ProjectCreationDTO projectDTO);
    Optional<Void> deleteProject(String id);


}
