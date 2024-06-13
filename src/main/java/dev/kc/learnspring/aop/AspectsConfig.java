package dev.kc.learnspring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectsConfig {

    @Bean
    public LoggingAspect customLoggingAspect(){
        return new LoggingAspect();
    }
}
