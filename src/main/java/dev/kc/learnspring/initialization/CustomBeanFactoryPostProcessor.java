package dev.kc.learnspring.initialization;

import dev.kc.learnspring.beans.DeprecatedTimepassBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertySourceProcessor;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("{} is a BeanFactoryPostProcessor",getClass().getSimpleName());
        beanFactory.ignoreDependencyType(DeprecatedTimepassBean.class);
//        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
//        cfg.setLocation(new FileSystemResource("tapp.properties"));
//        Properties properties = new Properties();
//        cfg.setIgnoreUnresolvablePlaceholders(true);
//        properties.put("kc.name","run-time via bpp");
//        cfg.setProperties(properties);
//        System.setProperty("kc.name","spring");
//        cfg.postProcessBeanFactory(beanFactory);
    }
}
