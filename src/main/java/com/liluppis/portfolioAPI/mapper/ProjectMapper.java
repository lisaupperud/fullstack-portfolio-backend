package com.liluppis.portfolioAPI.mapper;

import com.liluppis.portfolioAPI.dto.ProjectDTO;
import com.liluppis.portfolioAPI.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectDTO toDTO(Project project) {
        return new ProjectDTO(
                project.getName(),
                project.getDesc(),
                project.getLink(),
                project.getTags(),
                project.getIconKey()
        );
    }

    public Project toEntity(ProjectDTO dto) {
        return Project.builder()
                .name(dto.getName())
                .desc(dto.getDesc())
                .link(dto.getLink())
                .tags(dto.getTags())
                .iconKey(dto.getIconKey())
                .build();
    }
}
