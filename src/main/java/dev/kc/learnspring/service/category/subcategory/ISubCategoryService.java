package dev.kc.learnspring.service.category.subcategory;

import dev.kc.learnspring.model.SubCategoryModel;

import java.util.List;

public interface ISubCategoryService {

    public String subCategoryName();

    public List<SubCategoryModel> findSubCategories(String categoryName);
}
