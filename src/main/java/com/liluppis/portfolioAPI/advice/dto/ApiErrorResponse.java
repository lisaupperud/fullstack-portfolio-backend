package com.liluppis.portfolioAPI.advice.dto;

import java.util.List;

public record ApiErrorResponse(
        int status,
        String error,
        List<ValidationError> errors
) {
}
