package com.liluppis.portfolioAPI.mapper;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectCreationDTO toDTO(Project project) {
        return new ProjectCreationDTO(
                project.name(),
                project.desc(),
                project.link(),
                project.tags(),
                project.iconKey()
        );
    }

    public Project toEntity(ProjectCreationDTO dto) {
        return Project.builder()
                .name(dto.name())
                .desc(dto.desc())
                .link(dto.link())
                .tags(dto.tags())
                .iconKey(dto.iconKey())
                .build();
    }
}
