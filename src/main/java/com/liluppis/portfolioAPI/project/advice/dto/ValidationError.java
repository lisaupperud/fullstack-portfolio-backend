package com.liluppis.portfolioAPI.project.advice.dto;

public record ValidationError(
        String field,
        String message
) {
}
