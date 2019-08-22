package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.ImageURLDao;
import com.rastkosasic.shop.entity.ImageURL;
 
@Service("imageURLService")
public class ImageURLService {
 
    @Autowired
    @Qualifier("imageURLDao")
    private ImageURLDao imageURLDao;
 
    @Transactional
    public ImageURL getImageURLById(long imageURLId) {
        return imageURLDao.selectImageURLById(imageURLId);
    }
 
    @Transactional
    public void addImageURL(ImageURL newImageURL) {
        imageURLDao.insertImageURL(newImageURL);
    }
 
    @Transactional
    public void modifyImageURL(ImageURL imageURL) {
        imageURLDao.updateImageURL(imageURL);
    }
 
    @Transactional
    public List<ImageURL> getAllImageURLs() {
        return imageURLDao.selectAllImageURLs();
 
    }
    

    @Transactional
    public void removeImageURL(long imageURLId) {
        imageURLDao.deleteImageURL(imageURLId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return imageURLDao.selectNumberOfRecordsInImageURLTable();
 
    }
    
    @Transactional
    public List<Long> getImageURLIdOfLastRecord() {
        return imageURLDao.selectImageURLIdOfLastRecord();
    }
 
}
