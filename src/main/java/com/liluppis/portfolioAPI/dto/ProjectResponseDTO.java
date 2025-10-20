package com.liluppis.portfolioAPI.dto;

import java.util.List;

public record ProjectResponseDTO(
        String name,
        String desc,
        String link,
        List<String> tags,
        String iconKey
) {
}
