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

import com.rastkosasic.shop.entity.RepresentativeProduct;
import com.rastkosasic.shop.service.RepresentativeProductService;
 
@RestController
public class RepresentativeProductController {
 
    @Autowired
    @Qualifier("representativeProductService")
    private RepresentativeProductService representativeProductService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_representative_product")
    public void createNewRepresentativeProduct(@Valid @RequestBody RepresentativeProduct representativeProduct) {
        representativeProductService.addRepresentativeProduct(representativeProduct);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_representative_product")
    public void changeExistingRepresentativeProduct(@Valid @RequestBody RepresentativeProduct representativeProduct) {
        representativeProductService.modifyRepresentativeProduct(representativeProduct);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_representative_product/{id}")
    public void deleteRepresentativeProduct(@PathVariable(value = "id") long representativeProductId) {
        representativeProductService.removeRepresentativeProduct(representativeProductId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_representative_product/{id}")
    public RepresentativeProduct getRepresentativeProductById(@PathVariable(value = "id") long representativeProductId) {
        return representativeProductService.getRepresentativeProductById(representativeProductId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_representative_products")
    public List<RepresentativeProduct> getAllRepresentativeProducts() {
        return representativeProductService.getAllRepresentativeProducts();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_representative_product_records")
    public List<Long> getNumberOfRecords() {
        return representativeProductService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_representative_product_record")
    public List<Long> getRepresentativeProductIdOfLastRecord() {
        return representativeProductService.getRepresentativeProductIdOfLastRecord();
    }
 
}
