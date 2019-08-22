package com.rastkosasic.shop.controller;

import java.util.List;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rastkosasic.shop.entity.ProductCategory;
import com.rastkosasic.shop.service.ProductCategoryService;
 
@RestController
public class ProductCategoryController {
 
    @Autowired
    @Qualifier("productCategoryService")
    private ProductCategoryService productCategoryService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_product_category")
    public void createNewProductCategory(@Valid @RequestBody ProductCategory productCategory) {
        productCategoryService.addProductCategory(productCategory);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_product_category")
    public void changeExistingProductCategory(@Valid @RequestBody ProductCategory productCategory) {
        productCategoryService.modifyProductCategory(productCategory);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_product_category/{id}")
    public void deleteProductCategory(@PathVariable(value = "id") long productCategoryId) {
        productCategoryService.removeProductCategory(productCategoryId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_product_category/{productId}/{categoryId}")
    public void delete(@PathVariable(value = "productId") long productId, @PathVariable(value = "categoryId") long categoryId) {
        productCategoryService.removeProductCategory(productId, categoryId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_product_category/{id}")
    public ProductCategory getProductCategoryById(@PathVariable(value = "id") long productCategoryId) {
        return productCategoryService.getProductCategoryById(productCategoryId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_product_categories")
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_product_category_records")
    public List<Long> getNumberOfRecords() {
        return productCategoryService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_product_category_record")
    public List<Long> getCategoryIdOfLastRecord() {
        return productCategoryService.getProductCategoryIdOfLastRecord();
    }
 
}
