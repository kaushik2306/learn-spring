package dev.kc.learnspring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
public class Service3 implements IService{

    private static final Logger log = LoggerFactory.getLogger(Service3.class);

    @PostConstruct
    public void init(){
    log.info("{} post-construct",getClass().getSimpleName());
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
