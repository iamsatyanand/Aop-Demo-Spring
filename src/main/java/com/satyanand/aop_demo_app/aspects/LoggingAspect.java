package com.satyanand.aop_demo_app.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    // * - any kind of return type
//    // before any method call named as orderPackage in any class
//    // (..) method accepting any number of arguments
//    @Before("execution (* orderPackage(..))")
//    // inside the impl folder orderPackage present in any number of files
//    @Before("execution(* com.satyanand.aop_demo_app.services.impl.*.orderPackage(..))")
//    // before orderPackage inside this particular class lie in this path only
//    @Before("execution(* com.satyanand.aop_demo_app.services.impl.ShipmentServiceImpl.orderPackage(..))")
    // call this aspect before any method any class inside impl package
    @Before("execution(* com.satyanand.aop_demo_app.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before aspect called from Logging aspect kind, {}",joinPoint.getKind() );
        log.info("Before aspect called from Logging aspect signature, {}", joinPoint.getSignature());
    }

//    // call within any package not only for single method but for every files inside any package
//    @Before("within (com.satyanand.aop_demo_app.services.impl.*)")
    // call all the class and methods inside any package or the subpackages within aop_demo_app package
    @Before("within (com.satyanand.aop_demo_app..*)")
    public void beforeServiceImplCalls(){
        log.info("Service impl calls");
    }

//    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")

    @Before("myLoggingAndAopMethodsPointcut")
    public void beforeMyLoggingAndAopMethodsCalls(){
        log.info("Before mylogging annotation calls.");
    }

    @After("myLoggingAndAopMethodsPointcut")
    public void afterMyLoggingAndAopMethodsCalls(){
        log.info("Before mylogging annotation calls.");
    }


    //we can also use multiple pointcuts
    // also we can declare same pointcuts with empty method and use them in multiple advices
    @Pointcut("@annotation(com.satyanand.aop_demo_app.aspects.MyLogging) && within (com.satyanand.aop_demo_app..*)")
    public void myLoggingAndAopMethodsPointcut(){

    }

}
