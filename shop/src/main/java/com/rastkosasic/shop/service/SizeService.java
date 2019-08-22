package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.SizeDao;
import com.rastkosasic.shop.entity.Size;
 
@Service("sizeService")
public class SizeService {
 
    @Autowired
    @Qualifier("sizeDao")
    private SizeDao sizeDao;
 
    @Transactional
    public Size getSizeById(long sizeId) {
        return sizeDao.selectSizeById(sizeId);
    }
 
    @Transactional
    public void addSize(Size newSize) {
        sizeDao.insertSize(newSize);
    }
 
    @Transactional
    public void modifySize(Size size) {
        sizeDao.updateSize(size);
    }
 
    @Transactional
    public List<Size> getAllSizes() {
        return sizeDao.selectAllSizes();
 
    }
    
 
    @Transactional
    public void removeSize(long sizeId) {
        sizeDao.deleteSize(sizeId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return sizeDao.selectNumberOfRecordsInSizeTable();
 
    }
    
    @Transactional
    public List<Long> getSizeIdOfLastRecord() {
      return sizeDao.selectSizeIdOfLastRecord();
    }
 
}