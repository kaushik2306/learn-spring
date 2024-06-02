package dev.kc.learnspring;

import dev.kc.learnspring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("dev.kc.learnspring")
public class LearnSpringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationCtx = new AnnotationConfigApplicationContext(LearnSpringApplication.class);
		AppConfig appConfig = applicationCtx.getBean("appConfig",AppConfig.class);
	}

}
