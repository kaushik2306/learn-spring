package dev.kc.learnspring.service.category.subcategory;

import dev.kc.learnspring.model.CategoryModel;
import dev.kc.learnspring.model.SubCategoryModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SubCategoryService implements ISubCategoryService{


    private static final Logger log = LoggerFactory.getLogger(SubCategoryService.class);

    private JdbcTemplate jdbcTemplate;

    public SubCategoryService(JdbcTemplate jdbcTemplate){
        log.info("{} Constructor invoked",getClass().getSimpleName());
        this.jdbcTemplate = jdbcTemplate;
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
            case "ELECTRONICS" ->  List.of(new SubCategoryModel(1L,"PHONE",null),new SubCategoryModel(2L,"TELEVISION",null));
            case "HEALTH" -> List.of(new SubCategoryModel(1L,"Beauty and Care",null),new SubCategoryModel(2L,"MEDICINES",null));
            default -> throw new IllegalStateException("Unexpected value: " + categoryName);
        };
    }

    public CategoryModel findCategory(String name){
        Long categoryId = jdbcTemplate.queryForObject("SELECT CATEGORY_ID FROM SubCategory WHERE NAME=?",Long.class,name);
        return jdbcTemplate.queryForObject("SELECT * FROM SubCategory WHERE ID=?", new CategoryMapper(),categoryId);
    };

    private static  class CategoryMapper implements RowMapper<CategoryModel>{

        @Override
        public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("ID");
            String name = rs.getString("NAME");
            return new CategoryModel(id,name);
        }
    }
}
