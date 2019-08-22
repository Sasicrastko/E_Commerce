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

import com.rastkosasic.shop.entity.InCartProduct;
import com.rastkosasic.shop.service.InCartProductService;
 
@RestController
public class InCartProductController {
 
    @Autowired
    @Qualifier("inCartProductService")
    private InCartProductService inCartProductService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_in_cart_product")
    public void createNewInCartProduct(@Valid @RequestBody InCartProduct inCartProduct) {
        inCartProductService.addInCartProduct(inCartProduct);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_in_cart_product")
    public void changeExistingInCartProduct(@Valid @RequestBody InCartProduct inCartProduct) {
        inCartProductService.modifyInCartProduct(inCartProduct);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_in_cart_product/{id}")
    public void deleteInCartProduct(@PathVariable(value = "id") long inCartProductId) {
        inCartProductService.removeInCartProduct(inCartProductId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_in_cart_product/{id}")
    public InCartProduct getInCartProductById(@PathVariable(value = "id") long inCartProductId) {
        return inCartProductService.getInCartProductById(inCartProductId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_In_cart_products")
    public List<InCartProduct> getAllInCartProducts() {
        return inCartProductService.getAllInCartProducts();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_in_cart_product_records")
    public List<Long> getNumberOfRecords() {
        return inCartProductService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_in_cart_product_record")
    public List<Long> getInCartProductIdOfLastRecord() {
        return inCartProductService.getInCartProductIdOfLastRecord();
    }
 
}
