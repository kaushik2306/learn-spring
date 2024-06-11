package dev.kc.learnspring.service.category.subcategory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService implements ISubCategoryService{


    private static final Logger log = LoggerFactory.getLogger(SubCategoryService.class);

    public SubCategoryService(){
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct invoked",getClass().getSimpleName());
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy invoked",getClass().getSimpleName());
    }

    @Override
    public String subCategoryName() {
        return getClass().getSimpleName();
    }

    public String calculateAndGetSubCategory(){
        return "";
    }

}
