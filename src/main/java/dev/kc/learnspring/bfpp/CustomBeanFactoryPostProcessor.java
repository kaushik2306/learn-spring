package dev.kc.learnspring.bfpp;

import dev.kc.learnspring.beans.DeprecatedTimepassBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanFactoryPostProcessor.class);

    /**
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.ignoreDependencyType(DeprecatedTimepassBean.class);
        StringBuffer sb = new StringBuffer();
        sb.append("\n========= [ CUSTOM BEAN-FACTORY POST PROCESSOR (BFPP) ] ========");
        sb.append("\nCustomBeanFactoryPostProcessor postProcessBeanFactory() invoked");
        sb.append(String.format("\nDoes JDBC BEAN DEFINITION PRESET ? %s",beanFactory.containsBeanDefinition("jdbcRepoImpl")));
        sb.append(String.format("\nDoes TimePass BEAN DEFINITION PRESET ? %s",beanFactory.containsBeanDefinition("timepassBean")));
        sb.append("\nAll Bean names = "+List.of(beanFactory.getBeanDefinitionNames()));
        sb.append("\nDependecies of a Bean RepoServices are? "+ List.of(beanFactory.getDependenciesForBean("repoServices")));

        sb.append("\n===============================================================\n");
     log.info(sb.toString());
    }
}
