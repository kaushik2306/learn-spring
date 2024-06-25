package dev.kc.learnspring.controller;

import dev.kc.learnspring.annotations.CustomMethodAnnotation;
import dev.kc.learnspring.model.ProductModel;
import dev.kc.learnspring.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    @CustomMethodAnnotation
    public List<ProductModel> getAllProducts(){
        //return productService.findAllProducts();
        return productService.findAllProductsUsingJdbcTemplate();
    }

    @PostMapping("/")
    @CustomMethodAnnotation
    public ProductModel addProduct(@RequestBody ProductModel productModel){
        return productService.addProduct(productModel);
    }

    @GetMapping("/count")
    public Long getProductCount(){
        return productService.getProductCount();
    }
}
