package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectDTO;
import com.liluppis.portfolioAPI.mapper.ProjectMapper;
import com.liluppis.portfolioAPI.model.Project;
import com.liluppis.portfolioAPI.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper mapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,  ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ProjectDTO> getProject(String id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(mapper::toDTO);
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project =  mapper.toEntity(projectDTO);
        projectRepository.save(project);
        return projectDTO;
    }
}
