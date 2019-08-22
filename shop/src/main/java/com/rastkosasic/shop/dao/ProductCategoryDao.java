package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.ProductCategory;
 
@Repository("productCategoryDao")
public class ProductCategoryDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public ProductCategory selectProductCategoryById(long productCategoryId) {
        return entityManager.find(ProductCategory.class, productCategoryId);
    }
 
    public void insertProductCategory(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }
 
    public void updateProductCategory(ProductCategory productCategory) {
 
        ProductCategory productCategoryToUpdate = selectProductCategoryById(productCategory.getProductCategoryId());
 
        productCategoryToUpdate.setFkProductId(productCategory.getFkProductId());
        productCategoryToUpdate.setFkCategoryId(productCategory.getFkCategoryId());
        productCategoryToUpdate.setCreatedAt(productCategory.getCreatedAt());
        productCategoryToUpdate.setUpdatedAt(productCategory.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteProductCategory(long productCategoryId) {
        entityManager.remove(selectProductCategoryById(productCategoryId));
    }
    
    public void deleteProductCategory(long productId, long categoryId) {
        Query query = entityManager.createQuery("DELETE FROM ProductCategory AS pc WHERE pc.fkProductId=" + productId + " AND pc.fkCategoryId=" + categoryId);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<ProductCategory> selectAllProductCategories() {
        Query query = entityManager.createQuery("FROM ProductCategory AS pc ORDER BY pc.productCategoryId");
        return (List<ProductCategory>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectNumberOfRecordsInProductCategoryTable() {
        Query query = entityManager.createQuery("select count(*) as numberOfRecords FROM ProductCategory");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectProductCategoryIdOfLastRecord() {
        Query query = entityManager.createQuery("select max(productCategoryId) as lastInsertedProductCategoryId  from ProductCategory");
        return (List<Long>) query.getResultList();
    }
 
}
