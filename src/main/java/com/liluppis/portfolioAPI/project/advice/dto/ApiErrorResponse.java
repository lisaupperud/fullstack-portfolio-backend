package com.liluppis.portfolioAPI.project.advice.dto;

import java.util.List;

public record ApiErrorResponse(
        int status,
        String error,
        List<ValidationError> errors
) {
}
