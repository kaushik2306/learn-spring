package dev.kc.learnspring.service;

import dev.kc.learnspring.beans.ITimepassBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    private static final Logger log = LoggerFactory.getLogger(Service2.class);

    private final IService service1;

    private final ITimepassBean timepassBean;

    public Service2(IService service1, ITimepassBean timepassBean) {
        this.service1 = service1;
        this.timepassBean = timepassBean;
        log.info("{} Constructor",Service2.class.getSimpleName());
    }

    @PostConstruct
    public void init(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%s post-construct\n",getClass().getSimpleName()));
        sb.append("%s timepassBean toString\n".formatted(timepassBean));
        log.info(sb.toString());
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",getClass().getSimpleName());
    }
}
