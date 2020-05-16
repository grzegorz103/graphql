package com.system.car.api.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private T body;

    public ApiResponse(T body) {
        this.body = body;
    }

}
