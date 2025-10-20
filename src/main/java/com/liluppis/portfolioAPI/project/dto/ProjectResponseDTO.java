package com.liluppis.portfolioAPI.project.dto;

import java.util.List;

public record ProjectResponseDTO(
        String id,
        String name,
        String desc,
        String link,
        List<String> tags,
        String iconKey
) {
}