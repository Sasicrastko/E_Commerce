package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.ProductCategoryDao;
import com.rastkosasic.shop.entity.ProductCategory;
 
@Service("productCategoryService")
public class ProductCategoryService {
 
    @Autowired
    @Qualifier("productCategoryDao")
    private ProductCategoryDao productCategoryDao;
 
    @Transactional
    public ProductCategory getProductCategoryById(long categoryId) {
        return productCategoryDao.selectProductCategoryById(categoryId);
    }
 
    @Transactional
    public void addProductCategory(ProductCategory newProductCategory) {
        productCategoryDao.insertProductCategory(newProductCategory);
    }
 
    @Transactional
    public void modifyProductCategory(ProductCategory productCategory) {
        productCategoryDao.updateProductCategory(productCategory);
    }
 
    @Transactional
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryDao.selectAllProductCategories();
 
    }
 
    @Transactional
    public void removeProductCategory(long productCategoryId) {
        productCategoryDao.deleteProductCategory(productCategoryId);
 
    }
    
    @Transactional
    public void removeProductCategory(long productId, long categoryId) {
        productCategoryDao.deleteProductCategory(productId, categoryId);
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return productCategoryDao.selectNumberOfRecordsInProductCategoryTable();
 
    }
    
    @Transactional
    public List<Long> getProductCategoryIdOfLastRecord() {
      return productCategoryDao.selectProductCategoryIdOfLastRecord();
    }
 
}
