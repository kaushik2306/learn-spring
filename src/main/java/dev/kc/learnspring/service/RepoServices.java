package dev.kc.learnspring.service;

import dev.kc.learnspring.beans.DeprecatedTimepassBean;
import dev.kc.learnspring.beans.ITimepassBean;
import dev.kc.learnspring.repo.IRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RepoServices {

    private static final Logger log = LoggerFactory.getLogger(RepoServices.class);

    private ITimepassBean timePassBeans;

    private IRepo repository;

    private IRepo jdbcRepository;

    private String appVersion = "NOT_SET";

//    public RepoServices() {
//        log.info("\nDEFAULT CONSTRUCTOR OF RepoServices invoked");
//    }


    public RepoServices(@Value("#{new Integer(environment['app.version'])*3}")String appVersion){
        this.appVersion = appVersion;
    }

    @Autowired
    public RepoServices(@Value("#{new Integer(environment['app.version'])*3}")String appVersion, @Qualifier("jpaRepoImpl") IRepo repository, IRepo jdbcRepoImpl, ITimepassBean timepassBeans){
        this.appVersion = appVersion;
        this.repository = repository;//This repo is autowired by @Qualifier name
        this.jdbcRepository = jdbcRepoImpl;//This repo is autowired by field name
        this.timePassBeans = timepassBeans;
    }

    @PostConstruct
    public void postInit(){
        log.info("\nRepoSerivces postInit"+this);
        log.info("\n IS TIMEPASS BEAN IGNORED DUE TO BFPP ? {}",this.timePassBeans);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("\nRepoServices preDestroy"+this);
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String repoName(){
        return "hello";
      //return  String.format("Multiple REPOS %s and %s",this.repository.getRepoName(),this.jdbcRepository.getRepoName());
    }
}
