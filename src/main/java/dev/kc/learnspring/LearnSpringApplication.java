package dev.kc.learnspring;

import dev.kc.learnspring.config.commons.AppConfig;
import dev.kc.learnspring.initialization.CustomBeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("dev.kc.learnspring")
public class LearnSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext applicationCtx = SpringApplication.run(AppConfig.class, args);
//		AppConfig appConfig = (AppConfig) applicationCtx.getBean("appConfig");
//		appConfig.testMe();
	}

}
