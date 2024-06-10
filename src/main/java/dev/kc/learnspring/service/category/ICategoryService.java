package dev.kc.learnspring.service.category;

import java.util.Collections;
import java.util.List;

public interface ICategoryService {

    public String categoryType();

    default List<String> getLatestCategories() { return Collections.emptyList();}
}
