package com.liluppis.portfolioAPI.service;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.dto.ProjectResponseDTO;
import com.liluppis.portfolioAPI.mapper.ProjectMapper;
import com.liluppis.portfolioAPI.model.Project;
import com.liluppis.portfolioAPI.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<ProjectResponseDTO> getProject(String id) {
        return projectRepository.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect((Collectors.toList()));

    }

    @Override
    public List<ProjectResponseDTO> getProjectsByTags(List<String> tags) {
        return List.of();
    }

    @Override
    public ProjectCreationDTO saveProject(ProjectCreationDTO projectDTO) {
        Project project =  mapper.toEntity(projectDTO);
        projectRepository.save(project);
        return projectDTO;
    }

    @Override
    public Optional<ProjectCreationDTO> updateProject(String id, ProjectCreationDTO projectDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Void> deleteProject(String id) {
        return Optional.empty();
    }
}
