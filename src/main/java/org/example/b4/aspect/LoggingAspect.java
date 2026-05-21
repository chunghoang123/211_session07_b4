package org.example.b4.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* org.example.b4.service..*(..))",
            throwing = "ex"
                )

    public void logException(JoinPoint joinPoint, Exception ex) {

        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + ex.getMessage());

    }

}
