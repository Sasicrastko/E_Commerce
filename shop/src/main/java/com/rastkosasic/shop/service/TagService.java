package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.TagDao;
import com.rastkosasic.shop.entity.Tag;
 
@Service("tagService")
public class TagService {
 
    @Autowired
    @Qualifier("tagDao")
    private TagDao tagDao;
 
    @Transactional
    public Tag getTagById(long tagId) {
        return tagDao.selectTagById(tagId);
    }
 
    @Transactional
    public void addTag(Tag newTag) {
        tagDao.insertTag(newTag);
    }
 
    @Transactional
    public void modifyTag(Tag tag) {
        tagDao.updateTag(tag);
    }
 
    @Transactional
    public List<Tag> getAllTags() {
        return tagDao.selectAllTags();
 
    }
    
    @Transactional
    public List<Tag> getProductTags(String productId) {
        return tagDao.selectAllTagsForProduct(productId);
 
    }
 
    @Transactional
    public void removeTag(long tagId) {
        tagDao.deleteTag(tagId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return tagDao.selectNumberOfRecordsInTagTable();
 
    }
    
    @Transactional
    public List<Long> getTagIdOfLastRecord() {
    	return tagDao.selectTagIdOfLastRecord();
    }
 
}