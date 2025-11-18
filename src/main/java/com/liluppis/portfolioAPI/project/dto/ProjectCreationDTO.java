package com.liluppis.portfolioAPI.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ProjectCreationDTO(
        @NotBlank(message = "Project must have a name")
        String name,
        @NotBlank(message = "Project must have a description")
        String desc,
        @NotEmpty(message = "Project must contain a Link")
        List<String> link,
        List<String> tags,

        // Q: Can iconKey be null, and then be added in frontend?
        // Or do I add a value and then map the value to the image in frontend?
        String iconKey
) {

}
