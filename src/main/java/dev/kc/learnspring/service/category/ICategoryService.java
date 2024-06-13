package dev.kc.learnspring.service.category;

import dev.kc.learnspring.model.CategoryModel;

import java.util.Collections;
import java.util.List;

public interface ICategoryService {

    public String categoryType();

    default List<CategoryModel> getLatestCategories() { return Collections.emptyList();}

    default CategoryModel getCategoryById(Long id) { return null;}
}
