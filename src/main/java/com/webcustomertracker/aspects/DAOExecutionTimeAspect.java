package com.webcustomertracker.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DAOExecutionTimeAspect {


    private Logger logger = java.util.logging.Logger.getLogger(getClass().getName());

    @Around("com.webcustomertracker.aspects.Pointcuts.allDaoMethods()")
    public Object measureExecutionTimes(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long after = System.currentTimeMillis();
        logger.info("==============================> Method          " + proceedingJoinPoint.getSignature().toShortString() +
                "               Took         " + (after - before) + " milliSeconds to execute");
        return result;
    }
}
