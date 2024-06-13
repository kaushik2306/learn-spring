package dev.kc.learnspring.aop;

import dev.kc.learnspring.exceptions.CategoryNotFoundException;
import dev.kc.learnspring.model.CategoryModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Aspect
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * dev.kc..*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        /*
         * Note: Never throw Exception in @Before otherwise method will not be execution
         * */
        String methodName = joinPoint.getSignature().getName();
        log.info("[AOP] BEFORE {} METHOD",methodName);
    }

    @Before("execution(public * dev.kc..*Controller.*(..,java.lang.Long,..))")
    public void beforeMethodWithArg(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("[AOP] BEFORE {} METHOD WITH ARG TYPE",methodName);
    }
    @Before("execution(@dev.kc..annotations.CustomMethodAnnotation public * dev.kc..*Controller.*(..))")
    public void beforeMethodWithAnnotation(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("[AOP] BEFORE {} METHOD WITH ANNOTATION",methodName);
    }

    @After("execution(public * dev.kc..*Controller.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("[AOP] AFTER {} METHOD",methodName);
    }

    @AfterReturning(value = "execution(public * dev.kc..*Controller.*(..))",returning = "categories")
    public void afterReturning(JoinPoint joinPoint, List<CategoryModel> categories){
        /**
         * Note: Here the pointcut expression and return-type i.e. List<CategoryModel> both should match
         */
        String methodName = joinPoint.getSignature().getName();
        log.info("[AOP] AFTER-RETURNING {} METHOD & RETURN-VALUE {}",methodName,categories);
    }

    @AfterThrowing(value = "execution(public * dev.kc..*Controller.*(..))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, CategoryNotFoundException ex){
        /**
         * Note: Here the pointcut expression and exception-type i.e. CategoryNotFoundException both should match
         * Note: We can do exception translation by throwing a new Type of Exception from here
         * As we see here we get CategoryNotFoundException, but we are throwing RuntimeException
         */
        String methodName = joinPoint.getSignature().getName();
        log.error("[AOP] AFTER-THROWING "+methodName+" METHOD & EXCEPTION-MESSAGE "+ex.getMessage());
//        throw new RuntimeException(ex.getMessage());
    }

    @Around("execution(public * dev.kc..*Controller.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("[AOP] AROUND {} METHOD",methodName);
        Object object = null;
        try{
            object = proceedingJoinPoint.proceed();
        }catch (Throwable e){
            log.info("[AOP] AROUND {} METHOD & EXCEPTION-MESSAGE {}",methodName,e.getMessage());
            throw e;
        }
        log.info("[AOP] AROUND {} METHOD & RETURN-VALUE {}",methodName,object);
        return object;
    }
}
