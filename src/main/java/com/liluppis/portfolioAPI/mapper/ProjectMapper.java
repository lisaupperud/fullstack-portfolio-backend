package com.liluppis.portfolioAPI.mapper;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.dto.ProjectResponseDTO;
import com.liluppis.portfolioAPI.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponseDTO toDTO(Project project) {
        return new ProjectResponseDTO(
                project.id(),
                project.name(),
                project.desc(),
                project.link(),
                project.tags(),
                project.iconKey()
        );
    }

    public Project toEntity(ProjectCreationDTO dto) {
        return new Project(
                null,
                dto.name(),
                dto.desc(),
                dto.link(),
                dto.tags(),
                dto.iconKey()
        );
    }
}
