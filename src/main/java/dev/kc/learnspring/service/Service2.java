package dev.kc.learnspring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    private static final Logger log = LoggerFactory.getLogger(Service2.class);

    private final Service1 service1;

    public Service2(Service1 service1) {
        this.service1 = service1;
        log.info("{} Constructor",Service2.class.getSimpleName());
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct",Service2.class.getSimpleName());
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",Service2.class.getSimpleName());
    }
}
