package dev.kc.learnspring.config.commons;

import dev.kc.learnspring.config.dev.DevInfraConfig;
import dev.kc.learnspring.config.prod.ProdInfraConfig;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = "classpath:/myresource/props/app.properties")
@ComponentScan(value = {"dev.kc.learnspring"})
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

//    @Lazy
//    @Value("${server.port}")
//    private Integer serverLocalPort;
//
//    @Lazy
//    @Value("${app.version}")
//    private Double appVersion;/* The property mentioned in PropertySource is override with application properties file*/

    private final IInfraConfig infrastructureConfig;

    public AppConfig(IInfraConfig infrastructureConfig){
        this.infrastructureConfig = infrastructureConfig;
    }

    @PostConstruct
    public void postConstruct(){
        log.info("{} POST-CONSTRUCT",getClass().getSimpleName());
        //log.info("SERVER PORT IS {}",serverLocalPort);
    }

//    public void testMe(){
//        System.out.println(
//                "==== JAVA-CONFIGURATION (LEARNING)"
//                +"\nApplication name = "+ infrastructureConfig.getApplicationName()
//                +"\napp-version = "+appVersion
//                +"\nport = "+serverLocalPort
//                +"\nprofile = "+ infrastructureConfig.getProfileName()
//                +"\nobject-type = "+infrastructureConfig
//                +"\nspecific-property from application-<profile>.properties (my-name) = "+infrastructureConfig.getMyName()
//                +"\n=========="
//        );
//        System.out.println("APP VERSION = "+appVersion);
//    }
}
