package com.liluppis.portfolioAPI.advice.dto;

public record ValidationError(
        String field,
        String message
) {
}
