package com.liluppis.portfolioAPI.project.service;

import com.liluppis.portfolioAPI.project.advice.exception.EmptyListException;
import com.liluppis.portfolioAPI.project.advice.exception.ProjectNotFoundException;
import com.liluppis.portfolioAPI.project.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.project.dto.ProjectResponseDTO;
import com.liluppis.portfolioAPI.project.mapper.ProjectMapper;
import com.liluppis.portfolioAPI.project.model.Project;
import com.liluppis.portfolioAPI.project.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper mapper;

    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ProjectResponseDTO> getProject(String id) {

        Optional<ProjectResponseDTO> project = projectRepository
                .findById(id)
                .map(mapper::toDTO);

        if (project.isEmpty()) {
            throw new ProjectNotFoundException("Project with id {" + id + "} not found");
        }

        log.info("Project with id {} found", id);
        return project;

        // return projectRepository.findById(id).map(mapper::toDTO).orElseThrow();
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {

        List<ProjectResponseDTO> projectList = projectRepository.findAll().stream().map(mapper::toDTO).toList();

        if (projectList.isEmpty()) {
            throw new EmptyListException("Project list is empty");
        }

        return projectList;

        // return projectRepository.findAll().stream().map(mapper::toDTO).collect((Collectors.toList()));

    }

    @Override
    public List<ProjectResponseDTO> getProjectsByTags(String tag) {

        List<ProjectResponseDTO> projectList = projectRepository.findByTags(tag).stream().map(mapper::toDTO).toList();

        if (projectList.isEmpty()) {
            throw new EmptyListException("Project list is empty");
        }

        return projectList;

        /* return projectRepository.findByTags(tag)
                .stream()
                .map(mapper::toDTO)
                .collect((Collectors.toList())); */
    }

    @Override
    public ProjectResponseDTO saveProject(ProjectCreationDTO projectDTO) {
        return mapper.toDTO(projectRepository.save(mapper.toEntity(projectDTO)));
    }

    @Override
    public Optional<ProjectResponseDTO> updateProject(String id, ProjectCreationDTO projectDTO) {
        return projectRepository.findById(id)
                .map(existing ->
                {
                    Project updated = new Project(
                            existing.id(),
                            projectDTO.name() != null ? projectDTO.name() : existing.name(),
                            projectDTO.desc() != null ? projectDTO.desc() : existing.desc(),
                            projectDTO.link() != null ? projectDTO.link() : existing.link(),
                            projectDTO.tags() != null ? projectDTO.tags() : existing.tags(),
                            projectDTO.iconKey() != null ? projectDTO.iconKey() : existing.iconKey()
                    );

                    Project saved = projectRepository.save(updated);

                    return mapper.toDTO(saved);
                });
    }

    @Override
    public boolean deleteProject(String id) {
        Project projectToBeDeleted = projectRepository.findById(id).orElse(null);

        if (projectToBeDeleted != null) {
            projectRepository.delete(projectToBeDeleted);
            return true;
        }

        return false;
    }
}
