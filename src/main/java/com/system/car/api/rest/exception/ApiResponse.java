package com.system.car.api.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private String message;
    private Set<String> errorMessages;

    public ApiResponse(Set<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

}
