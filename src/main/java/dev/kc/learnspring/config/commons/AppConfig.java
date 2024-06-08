package dev.kc.learnspring.config.commons;

import dev.kc.learnspring.config.dev.DevInfraConfig;
import dev.kc.learnspring.config.prod.ProdInfraConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/myresource/props/app.properties")
@ComponentScan(value = {"dev.kc.learnspring"})
public class AppConfig {

    @Value("${server.port}")
    private Integer serverLocalPort;

    @Value("${app.version}")
    private Double appVersion;/* The property mentioned in PropertySource is override with application properties file*/

    private final IInfraConfig infrastructureConfig;

    public AppConfig(IInfraConfig infrastructureConfig){
        this.infrastructureConfig = infrastructureConfig;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Sever port in post construct = "+serverLocalPort);
    }

    public void testMe(){
        System.out.println(
                "==== JAVA-CONFIGURATION (LEARNING)"
                +"\nApplication name = "+ infrastructureConfig.getApplicationName()
                +"\napp-version = "+appVersion
                +"\nport = "+serverLocalPort
                +"\nprofile = "+ infrastructureConfig.getProfileName()
                +"\nobject-type = "+infrastructureConfig
                +"\nspecific-property from application-<profile>.properties (my-name) = "+infrastructureConfig.getMyName()
                +"\n=========="
        );
        System.out.println("APP VERSION = "+appVersion);
    }
}
