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

import com.rastkosasic.shop.entity.Product;
import com.rastkosasic.shop.service.ProductService;
 
@RestController
public class ProductController {
 
    @Autowired
    @Qualifier("productService")
    private ProductService productService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_product")
    public void createNewProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_product")
    public void changeExistingProduct(@Valid @RequestBody Product product) {
        productService.modifyProduct(product);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_product/{id}")
    public void deleteProduct(@PathVariable(value = "id") long productId) {
        productService.removeProduct(productId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_product/{id}")
    public Product getProductById(@PathVariable(value = "id") long productId) {
        return productService.getProductById(productId);
    }
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_products")
    public List<Product> getAllCategories() {
        return productService.getAllProducts();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_product_records")
    public List<Long> getNumberOfRecords() {
        return productService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_product_record")
    public List<Long> getCategoryIdOfLastRecord() {
        return productService.getCategoryIdOfLastRecord();
    }
 
}
