package com.webcustomertracker.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {


    @Pointcut("execution(* com.webcustomertracker.controller.*.*(..))")
    public void allControllers() {
    }


    @Pointcut("execution(* com.webcustomertracker.service.*.*(..))")
    public void allServiceMethods() {
    }

    @Pointcut("execution(* com.webcustomertracker.dao.*.*(..))")
    public void allDaoMethods() {
    }


    @Pointcut("allControllers() ||  allServiceMethods() || allDaoMethods()")
    public void loggingPointCut() {
    }


}
