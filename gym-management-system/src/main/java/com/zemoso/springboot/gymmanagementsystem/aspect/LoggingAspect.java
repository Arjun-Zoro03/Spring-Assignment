package com.zemoso.springboot.gymmanagementsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger myLogger=Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.zemoso.springboot.gymmanagementsystem.controller.*.*(..))")
    public void forControllerPackage()
    {}

    @Pointcut("execution(* com.zemoso.springboot.gymmanagementsystem.service.*.*.*(..))")
    public void forServicePackage()
    {}

    @Pointcut("execution(* zcom.zemoso.springboot.gymmanagementsystem.dao.*.*(..))")
    public void forDAOPackage()
    {}

    @Pointcut("forControllerPackage()||forServicePackage()||forDAOPackage()")
    public void forMainContentFlow()
    {}

    @Before("forMainContentFlow()")
    public void beforeExecution(JoinPoint joinPoint)
    {
        String myMethod=joinPoint.getSignature().toShortString();
        myLogger.info(("===>>> Executing @Before on calling method: "+myMethod));
        Object args[]=joinPoint.getArgs();
        for(Object arg:args)
        {
            myLogger.info("===>>> arguments: "+arg+"\n");
        }
    }

    @AfterReturning(pointcut = "forMainContentFlow()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result)
    {
        String myMethod=joinPoint.getSignature().toShortString();
        myLogger.info(("===>>> Executing @AfterReturning on calling method: "+myMethod));

        myLogger.info("\n ===>>> result is: "+result);

    }

}
