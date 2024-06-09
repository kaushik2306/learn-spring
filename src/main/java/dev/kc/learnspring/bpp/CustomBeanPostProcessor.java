package dev.kc.learnspring.bpp;

import dev.kc.learnspring.beans.RecentTimepassBean;
import dev.kc.learnspring.service.RepoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        StringBuffer sb = new StringBuffer();
        sb.append("\n========= [ CUSTOM BEAN POST PROCESSOR (BPP) ] ========\n");
        sb.append("beanName = "+beanName+"\n");
        sb.append("\n===============================================================\n");
        log.info(sb.toString());
        if(beanName.equals("deprecatedTimepassBean")){
            return new RecentTimepassBean();
        }
        return bean;
    }
}
