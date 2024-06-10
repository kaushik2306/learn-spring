package dev.kc.learnspring.service.category.subcategory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService implements ISubCategoryService{


    private static final Logger log = LoggerFactory.getLogger(SubCategoryService.class);

    public SubCategoryService(){
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @Override
    public String subCategoryName() {
        return getClass().getSimpleName();
    }

    public String calculateAndGetSubCategory(){
        return "";
    }

}
