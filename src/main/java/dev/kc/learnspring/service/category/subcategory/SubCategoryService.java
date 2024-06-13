package dev.kc.learnspring.service.category.subcategory;

import dev.kc.learnspring.model.SubCategoryModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SubCategoryModel> findSubCategories(String categoryName) {
        return switch (categoryName){
            case "ELECTRONICS" ->  List.of(new SubCategoryModel(1L,"PHONE"),new SubCategoryModel(2L,"TELEVISION"));
            case "HEALTH" -> List.of(new SubCategoryModel(1L,"Beauty and Care"),new SubCategoryModel(2L,"MEDICINES"));
            default -> throw new IllegalStateException("Unexpected value: " + categoryName);
        };
    }
}
