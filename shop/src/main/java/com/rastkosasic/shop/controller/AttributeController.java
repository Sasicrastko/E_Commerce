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

import com.rastkosasic.shop.entity.Attribute;
import com.rastkosasic.shop.service.AttributeService;
 
@RestController
public class AttributeController {
 
    @Autowired
    @Qualifier("attributeService")
    private AttributeService attributeService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_attribute")
    public void createNewAttribute(@Valid @RequestBody Attribute attribute) {
        attributeService.addAttribute(attribute);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_attribute")
    public void changeExistingAttribute(@Valid @RequestBody Attribute attribute) {
        attributeService.modifyAttribute(attribute);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_attribute/{id}")
    public void deleteAttribute(@PathVariable(value = "id") long attributeId) {
        attributeService.removeAttribute(attributeId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_attribute/{id}")
    public Attribute getAttributeById(@PathVariable(value = "id") long attributeId) {
        return attributeService.getAttributeById(attributeId);
    }
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_attributes")
    public List<Attribute> getAllCategories() {
        return attributeService.getAllAttributes();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_attribute_records")
    public List<Long> getNumberOfRecords() {
        return attributeService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_attribute_record")
    public List<Long> getCategoryIdOfLastRecord() {
        return attributeService.getCategoryIdOfLastRecord();
    }
 
}
 

