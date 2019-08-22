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

import com.rastkosasic.shop.entity.Category;
import com.rastkosasic.shop.service.CategoryService;
 
@RestController
public class CategoryController {
 
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_category")
    public void createNewCategory(@Valid @RequestBody Category category) {
        categoryService.addCategory(category);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_category")
    public void changeExistingCategory(@Valid @RequestBody Category category) {
        categoryService.modifyCategory(category);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_category/{id}")
    public void deleteCategory(@PathVariable(value = "id") long categoryId) {
        categoryService.removeCategory(categoryId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_category/{id}")
    public Category getCategoryById(@PathVariable(value = "id") long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_categories_for_product/{productId}")
    public List<Category> getProductCategories(@PathVariable(value = "productId") String productId) {
        return categoryService.getProductCategories(productId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_records")
    public List<Long> getNumberOfRecords() {
        return categoryService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_record")
    public List<Long> getCategoryIdOfLastRecord() {
        return categoryService.getCategoryIdOfLastRecord();
    }
 
}
