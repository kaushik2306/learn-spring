package dev.kc.learnspring.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${server.port}")
    private Integer serverLocalPort;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Sever port in post construct = "+serverLocalPort);
    }
}
