package dev.kc.learnspring.service;

import dev.kc.learnspring.repo.IRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class RepoServices {

    private static final Logger log = LoggerFactory.getLogger(RepoServices.class);
    private IRepo repository;

    private IRepo jdbcRepository;

    private String appVersion = "NOT_SET";

    public RepoServices() {
    }


    public RepoServices(@Value("#{new Integer(environment['app.version'])*3}")String appVersion){
        this.appVersion = appVersion;
    }

    @Autowired
    public RepoServices(@Qualifier("jpaRepoImpl") IRepo repository, IRepo jdbcRepoImpl){
        this.repository = repository;//This repo is autowired by @Qualifier name
        this.jdbcRepository = jdbcRepoImpl;//This repo is autowired by field name
    }

    @PostConstruct
    public void postInit(){
        log.info("RepoSerivces postInit");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("RepoServices preDestroy");
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String repoName(){
      return  String.format("Multiple REPOS %s and %s",this.repository.getRepoName(),this.jdbcRepository.getRepoName());
    }
}
