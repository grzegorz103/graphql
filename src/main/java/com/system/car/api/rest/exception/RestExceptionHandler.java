package com.system.car.api.rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice("com.system.car.api.rest")
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(ApplicationException exception,
                                                                WebRequest webRequest) {
        return super.handleExceptionInternal(exception, exception.getMessage(), null, exception.getExceptionType().getStatus(), webRequest);
    }

}
