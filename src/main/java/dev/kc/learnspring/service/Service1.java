package dev.kc.learnspring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    private static final Logger log = LoggerFactory.getLogger(Service1.class);
    /**
     * Concept of referring bean class members using SpEL
     * If the SpEL is correct it will load its Value
     * If the SpEL is incorrect application will fail by Exception: Expression parsing failed
     */
    @Value("#{repoServices.appVersion}")
    private Double myAppVersion;/* Concept of referring bean class members using SpEL*/

    public Service1() {
        log.info("{} Constructor",Service1.class.getSimpleName());
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct myAppversion {}",Service1.class.getSimpleName(),myAppVersion);
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",Service1.class.getSimpleName());
    }
}
