package dev.kc.learnspring.service.product;

import dev.kc.learnspring.model.ProductModel;
import dev.kc.learnspring.service.category.ICategoryService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    /**
     * Concept of referring bean class members using SpEL
     * If the SpEL is correct it will load its Value
     * If the SpEL is incorrect application will fail by Exception: Expression parsing failed
     */
    @Value("#{repoServices.appVersion}")
    private Double myAppVersion;/* Concept of referring bean class members using SpEL*/

    private ICategoryService categoryService;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public ProductService(){}

    @Autowired
    public ProductService(ICategoryService categoryService,DataSource dataSource, JdbcTemplate jdbcTemplate) {
        log.info("{} Constructor invoked",getClass().getSimpleName());
        this.categoryService = categoryService;
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init(){
        log.info("{} post-construct myAppversion {}",getClass().getSimpleName(),myAppVersion);
    }

    @PreDestroy
    public void tearDown(){
        log.info("{} pre-destroy",getClass().getSimpleName());
    }

    public void test(){
        log.info("{} Test me",this);
    }

    /**
     * FETCH ALL THE PRODUCT USING LOW-LEVEL JDBC API
     * @return {@code List<ProductModel>}
     */
    public List<ProductModel> findAllProducts(){
        noImpactOfInterceptorOnInnerCalls();
        var productModelList = new ArrayList<ProductModel>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUCT")){
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    productModelList.add(new ProductModel(rs.getLong("id"), rs.getString("name")));
                }
            }catch (SQLException e){
                log.error("Error while fetching result-set of PRODUCT",e);
            }
        }catch (SQLException e){
            log.error("Failed to fetch all products",e);
        }
        //return List.of(new ProductModel(1L,"XBOX"),new ProductModel(2L,"IPHONE"));
        return productModelList;
    }

    /**
     * FETCH ALL THE PRODUCT USING JDBC-TEMPLATE
     * @return {@code List<ProductModel>}
     */
    public List<ProductModel> findAllProductsUsingJdbcTemplate(){
        String sql = "SELECT * FROM PRODUCT";
        return jdbcTemplate.query(sql,new ProductModelRowMapper());
    }

    /**
     * API to fetch the total count of products in PRODUCT Table
     * @return count of total products
     */
    public Long getProductCount(){
        String sql = "SELECT COUNT(*) FROM PRODUCT";
        return jdbcTemplate.queryForObject(sql,Long.class);
    }

    /**
     * API to add new Product into database<br>
     * It uses JdbcTemplate
     * @param productModel Product to add in database
     * @return {@link ProductModel} updated Product after adding into database
     */
    public ProductModel addProductUsingJdbcTemplate(ProductModel productModel) {
        String sql = "INSERT INTO PRODUCT(NAME) VALUES(?)";
        jdbcTemplate.update(sql, productModel.name());
        String fetchSql = "SELECT * FROM PRODUCT WHERE NAME=?";
        return jdbcTemplate.queryForObject(fetchSql, new ProductModelRowMapper(),productModel.name());
    }

    /**
     * API to add new Product into database<br>
     * It uses LOW-LEVEL JDBC API to do the operation
     * @param productModel Product to add in database
     * @return {@link ProductModel} updated Product after adding into database
     */
    public ProductModel addProduct(ProductModel productModel){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("INSERT INTO PRODUCT(NAME) VALUES(?)")){
            ps.setString(1,productModel.name());
            ps.execute();

            try(PreparedStatement fetch = connection
                    .prepareStatement("SELECT * FROM PRODUCT WHERE NAME=?")){
                fetch.setString(1,productModel.name());
                try(ResultSet rs = fetch.executeQuery()){
                    while (rs.next()){
                        return new ProductModel(rs.getLong("id"), rs.getString("name"));
                    }
                }catch (SQLException e){
                    log.error("Error while fetching result-set of PRODUCT",e);
                    throw new RuntimeException("Error while fetching result-set of PRODUCT",e);
                }
            }

        }catch (SQLException e){
            log.error("Failed to add product",e);
            throw new RuntimeException("Failed to add product",e);
        }
        return null;
    }

    public void noImpactOfInterceptorOnInnerCalls(){
        log.info("No impact of interceptor on inner method calls");
    }

    private static class ProductModelRowMapper implements RowMapper<ProductModel> {
        @Override
        public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ProductModel(rs.getLong("id"),rs.getString("name"));
        }
    }
}
