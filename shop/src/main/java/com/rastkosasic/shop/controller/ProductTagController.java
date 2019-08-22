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

import com.rastkosasic.shop.entity.ProductTag;
import com.rastkosasic.shop.service.ProductTagService;
 
@RestController
public class ProductTagController {
 
    @Autowired
    @Qualifier("productTagService")
    private ProductTagService productTagService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_product_tag")
    public void createNewProductTag(@Valid @RequestBody ProductTag productTag) {
        productTagService.addProductTag(productTag);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_product_tag")
    public void changeExistingProductTag(@Valid @RequestBody ProductTag productTag) {
        productTagService.modifyProductTag(productTag);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_product_tag/{id}")
    public void deleteProductTag(@PathVariable(value = "id") long productTagId) {
        productTagService.removeProductTag(productTagId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_product_tag/{productId}/{tagId}")
    public void delete(@PathVariable(value = "productId") long productId, @PathVariable(value = "tagId") long tagId) {
        productTagService.removeProductTag(productId, tagId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_product_tag/{id}")
    public ProductTag getProductTagById(@PathVariable(value = "id") long productTagId) {
        return productTagService.getProductTagById(productTagId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_product_tags")
    public List<ProductTag> getAllProductTags() {
        return productTagService.getAllProductTags();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_product_tag_records")
    public List<Long> getNumberOfRecords() {
        return productTagService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_product_tag_record")
    public List<Long> getTagIdOfLastRecord() {
        return productTagService.getProductTagIdOfLastRecord();
    }
 
}
