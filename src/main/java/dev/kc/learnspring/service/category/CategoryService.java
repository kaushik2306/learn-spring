package dev.kc.learnspring.service.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * This Category Service is not being Deprecated
 * Please refer {@link }
 */
@Service
@Deprecated
public class CategoryService implements ICategoryService{

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    public CategoryService(){
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @Override
    public String categoryType() {
        return getClass().getSimpleName()+" Category";
    }
}
