package dev.kc.learnspring.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibMethodInterceptor implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CgLibMethodInterceptor.class);

    private Object bean;

    public CgLibMethodInterceptor(Object bean){
        this.bean = bean;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        Class<?> aClass = obj.getClass();
        log.info("[CGLIB] BEFORE {} method in class {}",methodName,aClass.getSimpleName());
        Object proceed;
        try {
            proceed = proxy.invoke(bean,args);
            log.info("[CGLIB] AFTER {} method in class {}",methodName,aClass.getSimpleName());
        }catch (Exception e){
            log.error("[CGLIB] AFTER-THROWING {} method in class {}",methodName,aClass.getSimpleName());
            throw e;
        }
        return proceed;
    }
}
