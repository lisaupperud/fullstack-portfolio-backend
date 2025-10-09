package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectDTO;

import java.util.Optional;

public interface IProjectService {
    public Optional<ProjectDTO> getProject(String id);
    public ProjectDTO save(ProjectDTO projectDTO);
}
