package dev.kc.learnspring.controller;

import dev.kc.learnspring.service.category.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category/services")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        log.info("{} constructor injection",getClass().getSimpleName());
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<String> findAllLatestCategories(){
        return categoryService.getLatestCategories();
    }
}
