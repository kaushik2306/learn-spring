package dev.kc.learnspring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Service1 implements IService{

    private static final Logger log = LoggerFactory.getLogger(Service1.class);

    //@Value("${kc.name}")
    private String propertyFromBpp;

    /**
     * Concept of referring bean class members using SpEL
     * If the SpEL is correct it will load its Value
     * If the SpEL is incorrect application will fail by Exception: Expression parsing failed
     */
    @Value("#{repoServices.appVersion}")
    private Double myAppVersion;/* Concept of referring bean class members using SpEL*/

    public Service1(Environment environment) {
        log.info("{} Constructor {} {}",getClass().getSimpleName(),propertyFromBpp,environment.getProperty("kc.name"));
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct myAppversion {} and prop-bpp {}",getClass().getSimpleName(),myAppVersion,propertyFromBpp);
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",getClass().getSimpleName());
    }

    @Override
    public String greetMessage() {
        return getClass().getSimpleName()+" says Hello!!!";
    }

}
