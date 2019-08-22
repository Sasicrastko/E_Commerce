package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.CategoryDao;
import com.rastkosasic.shop.entity.Category;
//import com.rastkosasic.shop.entity.Category;
 
@Service("categoryService")
public class CategoryService {
 
    @Autowired
    @Qualifier("categoryDao")
    private CategoryDao categoryDao;
 
    @Transactional
    public Category getCategoryById(long categoryId) {
 
        return categoryDao.selectCategoryById(categoryId);
    }
 
    @Transactional
    public void addCategory(Category newCategory) {
        categoryDao.insertCategory(newCategory);
    }
    
    @Transactional
    public List<Category> getProductCategories(String productId) {
        return categoryDao.selectAllCategoriesForProduct(productId);
 
    }
 
 
    @Transactional
    public void modifyCategory(Category category) {
        categoryDao.updateCategory(category);
    }
 
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.selectAllCategories();
 
    }
 
    @Transactional
    public void removeCategory(long categoryId) {
        categoryDao.deleteCategory(categoryId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return categoryDao.selectNumberOfRecordsInCategoryTable();
 
    }
    
    @Transactional
    public List<Long> getCategoryIdOfLastRecord() {
    	return categoryDao.selectCategoryIdOfLastRecord();
    }
 
}

