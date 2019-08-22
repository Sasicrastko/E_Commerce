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

import com.rastkosasic.shop.entity.Size;
import com.rastkosasic.shop.service.SizeService;
 
@RestController
public class SizeController {
 
    @Autowired
    @Qualifier("sizeService")
    private SizeService sizeService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_size")
    public void createNewSize(@Valid @RequestBody Size size) {
        sizeService.addSize(size);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_size")
    public void changeExistingSize(@Valid @RequestBody Size size) {
        sizeService.modifySize(size);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_size/{id}")
    public void deleteSize(@PathVariable(value = "id") long sizeId) {
        sizeService.removeSize(sizeId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_size/{id}")
    public Size getSizeById(@PathVariable(value = "id") long sizeId) {
        return sizeService.getSizeById(sizeId);
    }
    

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_sizes")
    public List<Size> getAllSizes() {
        return sizeService.getAllSizes();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_size_records")
    public List<Long> getNumberOfRecords() {
        return sizeService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_size_record")
    public List<Long> getSizeIdOfLastRecord() {
        return sizeService.getSizeIdOfLastRecord();
    }
 
}  