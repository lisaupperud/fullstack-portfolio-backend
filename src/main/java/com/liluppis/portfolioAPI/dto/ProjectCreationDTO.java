package com.liluppis.portfolioAPI.dto;

import java.util.List;

public record ProjectCreationDTO(
        String name,
        String desc,
        String link,
        List<String> tags,
        String iconKey
) {

}
