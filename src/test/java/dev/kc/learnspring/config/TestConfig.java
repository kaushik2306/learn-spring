package dev.kc.learnspring.config;

import dev.kc.learnspring.config.commons.IInfraConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;

@Configuration
@Profile("test")
@ComponentScan("dev.kc.learnspring")
//@TestPropertySource(properties = {"spring.profiles.active=test","spring.application.name=e-commerce","my-name=kaushik","app.version=1.0","server.port=81"})
public class TestConfig implements IInfraConfig {

    @Override
    public String getApplicationName() {
        return "";
    }

    @Override
    public String getProfileName() {
        return "";
    }

    @Override
    public String getMyName() {
        return "";
    }
}
