package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.Category;

 
@Repository("categoryDao")
public class CategoryDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public Category selectCategoryById(long categoryId) {
        return entityManager.find(Category.class, categoryId);
    }
 
    public void insertCategory(Category category) {
        entityManager.persist(category);
    }
 
    public void updateCategory(Category category) {
 
        Category categoryToUpdate = selectCategoryById(category.getCategoryId());
 
        categoryToUpdate.setCategoryName(category.getCategoryName());
        categoryToUpdate.setCreatedAt(category.getCreatedAt());
        categoryToUpdate.setUpdatedAt(category.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteCategory(long categoryId) {
        entityManager.remove(selectCategoryById(categoryId));
    }
 
    @SuppressWarnings("unchecked")
	public List<Category> selectAllCategories() {
        Query query = entityManager.createQuery("from Category as ctg order by ctg.categoryId");
        return (List<Category>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Category> selectAllCategoriesForProduct(String productId) {
    	Query query = entityManager.createQuery("FROM Category as c where c.categoryId IN (SELECT fkCategoryId FROM ProductCategory where fkProductId=" + productId + ")");
        return (List<Category>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectNumberOfRecordsInCategoryTable() {
        Query query = entityManager.createQuery("select count(*) as numberOfRecords FROM Category");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectCategoryIdOfLastRecord() {
        Query query = entityManager.createQuery("select max(categoryId) as lastInsertedCategoryId  from Category");
        return (List<Long>) query.getResultList();
    }
 
}
