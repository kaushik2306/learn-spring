package dev.kc.learnspring.service.product;

import dev.kc.learnspring.service.category.ICategoryService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    /**
     * Concept of referring bean class members using SpEL
     * If the SpEL is correct it will load its Value
     * If the SpEL is incorrect application will fail by Exception: Expression parsing failed
     */
    @Value("#{repoServices.appVersion}")
    private Double myAppVersion;/* Concept of referring bean class members using SpEL*/

    private ICategoryService categoryService;

    public ProductService(){}

    @Autowired
    public ProductService(ICategoryService categoryService) {
        log.info("{} Constructor invoked",getClass().getSimpleName());
        this.categoryService = categoryService;
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct myAppversion {}",getClass().getSimpleName(),myAppVersion);
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",getClass().getSimpleName());
    }

    public void test(){
        log.info("{} Test me",this);
    }
}
