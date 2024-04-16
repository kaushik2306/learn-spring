package dev.kc.learnspring;

import dev.kc.learnspring.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationCtx = SpringApplication.run(LearnSpringApplication.class, args);
	}

}
