package com.webcustomertracker.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {


    private Logger logger = java.util.logging.Logger.getLogger(getClass().getName());


    @Before("com.webcustomertracker.aspects.Pointcuts.loggingPointCut()")
    public void beforeLogging(JoinPoint point) {
        logger.info("==============================> Calling method           " + point.getSignature().toShortString() +
                "               With parameters         " + Arrays.toString(point.getArgs()));
    }

    @AfterReturning(pointcut = "com.webcustomertracker.aspects.Pointcuts.loggingPointCut()", returning = "result")
    public void beforeLogging(JoinPoint point, Object result) {
        logger.info("==============================> Successfully Executed Method            " + point.getSignature().toShortString() +
                "               With parameters         " + Arrays.toString(point.getArgs())
                + "              The result is       " + result);
    }


}
