package com.system.car.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.system.car.services..*(..))", throwing = "e")
    public void logAfterExceptionInServices(Exception e) {
        log.error(e.getMessage());
    }

}
