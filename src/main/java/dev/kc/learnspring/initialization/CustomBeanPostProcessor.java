package dev.kc.learnspring.initialization;

import dev.kc.learnspring.beans.ITimepassBean;
import dev.kc.learnspring.beans.RecentTimepassBean;
import dev.kc.learnspring.service.Service1;
import dev.kc.learnspring.service.Service3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    public Service3 service3;

    public ITimepassBean timepassBean;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase(Service1.class.getSimpleName()) && service3==null){
            log.info("{} before init. Bean-name:{}",getClass().getSimpleName(),beanName);
            service3 = new Service3();
            return service3;
        }
//        else if(beanName.equalsIgnoreCase(Deprecated.class.getSimpleName()) && timepassBean==null){
//            log.info("{} after init. Bean-name:{}",getClass().getSimpleName(),beanName);
//            timepassBean = new RecentTimepassBean();
//            return timepassBean;
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase(Service1.class.getSimpleName()) && service3!=null){
            log.info("{} after init. Bean-name:{}",getClass().getSimpleName(),beanName);
            return service3;
        }
//        else if (beanName.equalsIgnoreCase(Deprecated.class.getSimpleName()) && timepassBean!=null){
//            log.info("{} after init. Bean-name:{}",getClass().getSimpleName(),beanName);
//            return timepassBean;
//        }
        return bean;
    }
}
