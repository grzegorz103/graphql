package com.system.car.api.rest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionType {

    HTTP_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occurred."),
    HTTP_NOT_FOUND(HttpStatus.NOT_FOUND, "Entity {0} (ID {1}) not found");

    private HttpStatus status;
    private String message;

    ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
