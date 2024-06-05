package dev.kc.learnspring.cmdrunner;

import dev.kc.learnspring.service.RepoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final RepoServices repoServices;

    private Logger logger = LoggerFactory.getLogger(getClass());



    public CustomCommandLineRunner(RepoServices repoServices){
        this.repoServices = repoServices;
    }

    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("Command line runner version {}",repoServices.getAppVersion());
        logger.info("Repo-Service name {}",repoServices.repoName());
    }

}
