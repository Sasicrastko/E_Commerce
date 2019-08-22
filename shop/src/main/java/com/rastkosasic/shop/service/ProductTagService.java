package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.ProductTagDao;
import com.rastkosasic.shop.entity.ProductTag;
 
@Service("productTagService")
public class ProductTagService {
 
    @Autowired
    @Qualifier("productTagDao")
    private ProductTagDao productTagDao;
 
    @Transactional
    public ProductTag getProductTagById(long tagId) {
        return productTagDao.selectProductTagById(tagId);
    }
 
    @Transactional
    public void addProductTag(ProductTag newProductTag) {
        productTagDao.insertProductTag(newProductTag);
    }
 
    @Transactional
    public void modifyProductTag(ProductTag productTag) {
        productTagDao.updateProductTag(productTag);
    }
 
    @Transactional
    public List<ProductTag> getAllProductTags() {
        return productTagDao.selectAllProductTags();
 
    }
 
    @Transactional
    public void removeProductTag(long productTagId) {
        productTagDao.deleteProductTag(productTagId);
 
    }
    
    @Transactional
    public void removeProductTag(long productId, long tagId) {
        productTagDao.deleteProductTag(productId, tagId);
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return productTagDao.selectNumberOfRecordsInProductTagTable();
 
    }
    
    @Transactional
    public List<Long> getProductTagIdOfLastRecord() {
    	return productTagDao.selectProductTagIdOfLastRecord();
    }
 
}
