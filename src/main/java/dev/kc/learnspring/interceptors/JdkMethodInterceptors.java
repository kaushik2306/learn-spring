package dev.kc.learnspring.interceptors;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdkMethodInterceptors implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(JdkMethodInterceptors.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        Class<?> aClass = invocation.getThis().getClass();
        log.info("[JDK] BEFORE {} method in class {}",methodName,aClass.getSimpleName());
        Object proceed;
        try {
            proceed = invocation.proceed();
            log.info("[JDK] AFTER {} method in class {}",methodName,aClass.getSimpleName());
        }catch (Exception e){
            log.error("[JDK] AFTER-THROWING {} method in class {}",methodName,aClass.getSimpleName());
            throw e;
        }
        return proceed;
    }
}
