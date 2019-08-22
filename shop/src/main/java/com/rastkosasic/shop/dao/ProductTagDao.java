package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.ProductTag;
 
@Repository("productTagDao")
public class ProductTagDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public ProductTag selectProductTagById(long productTagId) {
        return entityManager.find(ProductTag.class, productTagId);
    }
 
    public void insertProductTag(ProductTag productTag) {
        entityManager.persist(productTag);
    }
 
    public void updateProductTag(ProductTag productTag) {
 
        ProductTag productTagToUpdate = selectProductTagById(productTag.getProductTagId());
 
        productTagToUpdate.setFkProductId(productTag.getFkProductId());
        productTagToUpdate.setFkTagId(productTag.getFkTagId());
        productTagToUpdate.setCreatedAt(productTag.getCreatedAt());
        productTagToUpdate.setUpdatedAt(productTag.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteProductTag(long productTagId) {
        entityManager.remove(selectProductTagById(productTagId));
    }
    
    public void deleteProductTag(long productId, long tagId) {
    	Query query = entityManager.createQuery("DELETE FROM ProductTag AS PT WHERE PT.fkProductId=" + productId + " AND PT.fkTagId=" + tagId);
    	query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
	public List<ProductTag> selectAllProductTags() {
        Query query = entityManager.createQuery("FROM ProductTag AS pt ORDER BY pt.productTagId");
        return (List<ProductTag>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectNumberOfRecordsInProductTagTable() {
        Query query = entityManager.createQuery("select count(*) as numberOfRecords FROM ProductTag");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectProductTagIdOfLastRecord() {
        Query query = entityManager.createQuery("select max(productTagId) as lastInsertedProductTagId  from ProductTag");
        return (List<Long>) query.getResultList();
    }
 
}