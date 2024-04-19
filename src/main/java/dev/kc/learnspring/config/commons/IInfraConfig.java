package dev.kc.learnspring.config.commons;

import org.springframework.beans.factory.annotation.Value;

public interface IInfraConfig {
    String getApplicationName();
    String getProfileName();
    @Value("${my-name}")
    String getMyName();
}
