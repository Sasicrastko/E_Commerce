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

import com.rastkosasic.shop.entity.ImageURL;
import com.rastkosasic.shop.service.ImageURLService;
 
@RestController
public class ImageURLController {
 
    @Autowired
    @Qualifier("imageURLService")
    private ImageURLService imageURLService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_image_url")
    public void createNewImageURL(@Valid @RequestBody ImageURL imageURL) {
        imageURLService.addImageURL(imageURL);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_image_url")
    public void changeExistingImageURL(@Valid @RequestBody ImageURL imageURL) {
        imageURLService.modifyImageURL(imageURL);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_image_url/{id}")
    public void deleteImageURL(@PathVariable(value = "id") long imageURLId) {
        imageURLService.removeImageURL(imageURLId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_image_url/{id}")
    public ImageURL getImageURLById(@PathVariable(value = "id") long imageURLId) {
        return imageURLService.getImageURLById(imageURLId);
    }
    

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_image_urls")
    public List<ImageURL> getAllImageURLs() {
        return imageURLService.getAllImageURLs();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_imag_url_records")
    public List<Long> getNumberOfRecords() {
        return imageURLService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_image_url_record")
    public List<Long> getImageURLIdOfLastRecord() {
        return imageURLService.getImageURLIdOfLastRecord();
    }
 
}