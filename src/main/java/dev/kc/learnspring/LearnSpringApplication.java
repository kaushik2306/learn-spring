package dev.kc.learnspring;

import dev.kc.learnspring.config.AppConfig;
import dev.kc.learnspring.server.WebServer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.SpringServletContainerInitializer;

import java.util.Set;


public class LearnSpringApplication {

	public static void main(String[] args) {
		LearnSpringApplication a = new LearnSpringApplication();

//
		ApplicationContext applicationCtx = new AnnotationConfigApplicationContext(AppConfig.class);
//		WebServer webServer = new WebServer(8081);
////		RedirectHttpHandler redirectHttpHandler = new RedirectHttpHandler("/", "/dashboard");
//		webServer.start();
		//AppConfig appConfig = applicationCtx.getBean("appConfig",AppConfig.class);
	}

}
