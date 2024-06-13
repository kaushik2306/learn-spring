package dev.kc.learnspring.service.category;

import dev.kc.learnspring.exceptions.CategoryNotFoundException;
import dev.kc.learnspring.model.CategoryModel;
import dev.kc.learnspring.model.SubCategoryModel;
import dev.kc.learnspring.service.category.subcategory.ISubCategoryService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceV2 implements ICategoryService{

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceV2.class);

    private ISubCategoryService subCategoryService;

    public CategoryServiceV2() {
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @Override
    public String categoryType() {
        return getClass().getSimpleName();
    }

    @Override
    public List<CategoryModel> getLatestCategories() {
        this.noImpactOfInterceptorOnInnerCalls();
        var electronics = subCategoryService.findSubCategories("ELECTRONICS");
        var health = subCategoryService.findSubCategories("HEALTH");
        return List.of(
                new CategoryModel(1L,"ELECTRONICS",electronics),
                new CategoryModel(2L,"HEALTH",health)
        );
    }

    public void noImpactOfInterceptorOnInnerCalls(){
        log.info("No impact of interceptor on inner method calls");
    }

    @Override
    public CategoryModel getCategoryById(Long id){
        throw new CategoryNotFoundException("Category with id %s is not found".formatted(id));
    }

    @Autowired
    public void setSubCategoryService(ISubCategoryService subCategoryService){
        log.info("{} setSubCategoryService setter-injection",getClass().getSimpleName());
        this.subCategoryService = subCategoryService;
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct invoked",getClass().getSimpleName());
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy invoked",getClass().getSimpleName());
    }
}
