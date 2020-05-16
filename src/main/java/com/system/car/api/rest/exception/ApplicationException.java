package com.system.car.api.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    private final ExceptionType exceptionType;

    public ApplicationException(ExceptionType exceptionType,
                                Object... messages) {
        super(MessageFormat.format(exceptionType.getMessage(), messages));
        this.exceptionType = exceptionType;
    }

    public ApplicationException(ExceptionType exceptionType,
                                final Throwable cause,
                                Object... messageArguments) {
        super(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        this.exceptionType = exceptionType;
    }

}
