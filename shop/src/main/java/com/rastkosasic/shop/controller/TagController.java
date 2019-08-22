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

import com.rastkosasic.shop.entity.Tag;
import com.rastkosasic.shop.service.TagService;
 
@RestController
public class TagController {
 
    @Autowired
    @Qualifier("tagService")
    private TagService tagService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/create_new_tag")
    public void createNewTag(@Valid @RequestBody Tag tag) {
        tagService.addTag(tag);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/modify_tag")
    public void changeExistingTag(@Valid @RequestBody Tag tag) {
        tagService.modifyTag(tag);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/delete_tag/{id}")
    public void deleteTag(@PathVariable(value = "id") long tagId) {
        tagService.removeTag(tagId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_tag/{id}")
    public Tag getTagById(@PathVariable(value = "id") long tagId) {
        return tagService.getTagById(tagId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_tags_for_product/{productId}")
    public List<Tag> getProductTags(@PathVariable(value = "productId") String productId) {
        return tagService.getProductTags(productId);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_all_tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_number_of_tag_records")
    public List<Long> getNumberOfRecords() {
        return tagService.getNumberOfRecords();
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/get_id_of_last_tag_record")
    public List<Long> getTagIdOfLastRecord() {
        return tagService.getTagIdOfLastRecord();
    }
 
}
