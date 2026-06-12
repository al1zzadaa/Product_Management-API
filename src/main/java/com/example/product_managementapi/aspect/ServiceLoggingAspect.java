package com.example.product_managementapi.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLoggingAspect {

    @Before("execution(* com.example.product_managementapi.service.ProductService.*(..))")
    public void LoggingAspect(JoinPoint joinPoint) {
        log.info("Method called: {}",
                joinPoint.getSignature().getName());
    }


    @After("execution(* com.example.product_managementapi.service.ProductService.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("END: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.product_managementapi.service.ProductService.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("SUCCESS: {} -> {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.product_managementapi.service.ProductService.*(..))",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("ERROR in {}: {}", joinPoint.getSignature().getName(), ex.getMessage());
    }

    @Around("execution(* com.example.product_managementapi.service.ProductService.*(..))")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        log.info("{} took {} ms",
                pjp.getSignature().getName(),
                System.currentTimeMillis() - start);

        return result;
    }
}
