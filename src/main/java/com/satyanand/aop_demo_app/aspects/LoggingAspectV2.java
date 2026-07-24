package com.satyanand.aop_demo_app.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodsPointCut")
    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
        log.info("Before advice method call, {}", joinPoint.getSignature());
    }

//    @After("allServiceMethodsPointCut()")
    // this will be executed after the successful/normal execution
    // if the method is returning something and i have to use that object
    // then we can use this returning parameter and also keep same name in argument
    // of the advice also and in Object returnedObj we used in that object our returned object will be stored
    @AfterReturning(value = "allServiceMethodsPointCut()", returning = "returnedObj")
    public void afterServiceMethodCalls(JoinPoint joinPoint, Object returnedObj) {
        log.info("After returning advice method call, {}", joinPoint.getSignature());
        log.info("After returning returned value, {}", returnedObj);
    }

    @AfterThrowing("allServiceMethodsPointCut()")
    public void afterServiceMethodCallsThrows(JoinPoint joinPoint) {
        log.info("After throwing advice method call, {}", joinPoint.getSignature());
    }

    @Pointcut("execution (* com.satyanand.aop_demo_app.services.impl.*.*(..))")
    public void allServiceMethodsPointCut() {
    }

}
