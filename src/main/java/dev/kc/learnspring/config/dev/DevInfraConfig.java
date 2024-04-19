package dev.kc.learnspring.config.dev;

import dev.kc.learnspring.config.commons.AppConfig;
import dev.kc.learnspring.config.commons.IInfraConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "dev")
@Import(AppConfig.class)
public class DevInfraConfig implements IInfraConfig {
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${spring.profiles.active}")
    String profileName;

   // @Value("${my-name}")
    private String myName;

    @Override
    public String getProfileName() {
        return profileName;
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getMyName() {
        return myName;
    }
}
