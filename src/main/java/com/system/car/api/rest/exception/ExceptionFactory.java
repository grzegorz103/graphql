package com.system.car.api.rest.exception;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

@Slf4j
public class ExceptionFactory {

    public static ApplicationException create(final Throwable cause,
                                              final ExceptionType exceptionType,
                                              final Object... messageArguments) {
        log.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        return new ApplicationException(exceptionType, cause, messageArguments);
    }

}
