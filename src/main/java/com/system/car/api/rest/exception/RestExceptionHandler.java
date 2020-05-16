package com.system.car.api.rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @SuppressWarnings("FieldCanBeLocal")
    private final String BAD_REQUEST_MESSAGE = "Bad request";

    @SuppressWarnings("FieldCanBeLocal")
    private final String INTERNAL_SERVER_ERROR = "Internal server error";

    @ExceptionHandler(TransactionSystemException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValid(TransactionSystemException exception) {
        Throwable cause = exception.getRootCause();

        if (cause instanceof ConstraintViolationException) {
            Set<String> errorSet = ((ConstraintViolationException) cause)
                    .getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            return new ApiResponse<>(errorSet);
        }

        return new ApiResponse<>(BAD_REQUEST_MESSAGE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Collection<? extends String>> handleRestMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<String> errorSet = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e->e.getField() + " " + e.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiResponse<>(errorSet);
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> handleEntityNotFoundException(ApplicationException exception,
                                                             WebRequest webRequest) {
        return new ApiResponse<>(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<String> handleInternalServerErrorException(Exception exception) {
        return new ApiResponse<>(INTERNAL_SERVER_ERROR);
    }

}
