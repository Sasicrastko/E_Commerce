package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.AttributeDao;
import com.rastkosasic.shop.entity.Attribute;
 
@Service("attributeService")
public class AttributeService {
 
    @Autowired
    @Qualifier("attributeDao")
    private AttributeDao attributeDao;
 
    @Transactional
    public Attribute getAttributeById(long attributeId) {
 
        return attributeDao.selectAttributeById(attributeId);
    }
 
    @Transactional
    public void addAttribute(Attribute newAttribute) {
        attributeDao.insertAttribute(newAttribute);
    }
 
    @Transactional
    public void modifyAttribute(Attribute attribute) {
        attributeDao.updateAttribute(attribute);
    }
 
    @Transactional
    public List<Attribute> getAllAttributes() {
        return attributeDao.selectAllAttributes();
 
    }
 
    @Transactional
    public void removeAttribute(long attributeId) {
        attributeDao.deleteAttribute(attributeId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return attributeDao.selectNumberOfRecordsInAttributeTable();
 
    }
    
    @Transactional
    public List<Long> getCategoryIdOfLastRecord() {
        return attributeDao.selectAttributeIdOfLastRecord();
    }
 
}
