package com.liluppis.portfolioAPI.advice;

import com.liluppis.portfolioAPI.advice.dto.ApiErrorResponse;
import com.liluppis.portfolioAPI.advice.dto.ValidationError;
import com.liluppis.portfolioAPI.advice.exception.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;

public class GlobalExceptionHandler {


    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(WebExchangeBindException ex) {

        List<ValidationError> errorDetailList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream().map(
                        fieldError -> new ValidationError(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        )
                ).toList();

        return ResponseEntity.badRequest().body(new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        errorDetailList
                )
        );
    }


    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProjectNotFoundException(ProjectNotFoundException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                List.of()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

}
