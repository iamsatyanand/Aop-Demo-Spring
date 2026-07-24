package com.satyanand.aop_demo_app.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ValidationAspect {
    @Pointcut("execution (* com.satyanand.aop_demo_app.services.impl.*.*(..))")
    public void allServiceMethodsPointCut() {
    }

    @Around("allServiceMethodsPointCut()")
    public Object validateOrderId(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        Long orderId = (Long)args[0];

        if(orderId > 0 ) return joinPoint.proceed();
        return "cannot call with negative orderId";
    }
}
