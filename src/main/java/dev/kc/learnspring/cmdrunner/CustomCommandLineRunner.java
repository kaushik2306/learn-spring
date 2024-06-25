package dev.kc.learnspring.cmdrunner;

import dev.kc.learnspring.config.commons.AppConfig;
import dev.kc.learnspring.service.RepoServices;
import dev.kc.learnspring.service.category.ICategoryService;
import dev.kc.learnspring.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final RepoServices repoServices;

    private final ICategoryService categoryService;

    private final ProductService productService;

    private final AppConfig appConfig;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public CustomCommandLineRunner(RepoServices repoServices, ICategoryService categoryService, ProductService productService, AppConfig appConfig){
        this.repoServices = repoServices;
        this.categoryService = categoryService;
        this.productService = productService;
        this.appConfig = appConfig;
    }

    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("======== COMMAND LINE RUNNER ========");
        logger.info("Command line runner version {}",repoServices.getAppVersion());
        logger.info("Repo-Service name {}",repoServices.repoName());
        logger.info("CategoryServiceV2 name {}",categoryService);
        logger.info("ProductService name {}",productService);
        logger.info("ProductService test start");
        productService.test();
        logger.info("ProductService test end");

        appConfig.testMe();

    }

}
