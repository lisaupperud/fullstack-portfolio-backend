package com.liluppis.portfolioAPI.project.advice;

import com.liluppis.portfolioAPI.project.advice.dto.ApiErrorResponse;
import com.liluppis.portfolioAPI.project.advice.dto.ValidationError;
import com.liluppis.portfolioAPI.project.advice.exception.EmptyListException;
import com.liluppis.portfolioAPI.project.advice.exception.ProjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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

        log.warn("Validation failed {} -> errors {}",
                errorDetailList.size(),
                errorDetailList.stream()
                        .map(error -> error.field() + ": " + error.message())
                        .toList());


        return ResponseEntity.badRequest().body(new ApiErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        errorDetailList
                )
        );
    }


    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProjectNotFoundException(ProjectNotFoundException e) {

        log.warn(e.getMessage());


        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                List.of()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ApiErrorResponse> handleEmptyListException(EmptyListException e) {

        log.warn(e.getMessage());


        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.NO_CONTENT.value(),
                e.getMessage(),
                List.of()
        );

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(errorResponse);
    }

}
