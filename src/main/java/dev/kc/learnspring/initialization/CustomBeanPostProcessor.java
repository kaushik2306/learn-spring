package dev.kc.learnspring.initialization;

import dev.kc.learnspring.interceptors.CgLibMethodInterceptor;
import dev.kc.learnspring.interceptors.MethodLoggingInterceptors;
import dev.kc.learnspring.service.category.CategoryServiceV2;
import dev.kc.learnspring.service.category.ICategoryService;
import dev.kc.learnspring.service.category.subcategory.ISubCategoryService;
import dev.kc.learnspring.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Factory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ICategoryService || bean instanceof ISubCategoryService){
            log.info("{} postProcessBeforeInitialization",bean.getClass().getSimpleName());
            if(bean instanceof CategoryServiceV2){
                ProxyFactory proxyFactory = new ProxyFactory(bean);
                proxyFactory.addAdvice(new MethodLoggingInterceptors());
                log.info("Proxy of CategoryServiceV2 {}",proxyFactory);
                return proxyFactory.getProxy();
            }
        }else if (bean instanceof ProductService) {
            try {
                return cgLibProxyApproachOne(bean);
            } catch (Exception e) {
                return bean;
            }
        }

        return bean;
    }

    private Object cgLibProxyApproachOne(Object bean) throws Exception{
        CgLibMethodInterceptor interceptor = new CgLibMethodInterceptor(bean);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        //enhancer.setInterfaces(new Class<?>[] {MethodInterceptor.class});
        // enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        enhancer.setAttemptLoad(true);
        enhancer.setCallbackType(MethodInterceptor.class);
        Class<?> proxyClass = enhancer.createClass();
        Object proxy = ReflectionUtils.accessibleConstructor(proxyClass).newInstance();
        ((Factory) proxy).setCallbacks(new Callback[] {interceptor});
        return proxy;
    }

    private Object cgLibProxyApproachTwo(Object bean){
        CgLibMethodInterceptor interceptor = new CgLibMethodInterceptor(bean);
        return Enhancer.create(bean.getClass(),interceptor);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ICategoryService || bean instanceof ISubCategoryService){
            log.info("{} postProcessAfterInitialization",bean.getClass().getSimpleName());
        }
        return bean;
    }
}
