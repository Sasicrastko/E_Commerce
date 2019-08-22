package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.InCartProduct;
 
@Repository("inCartProductDao")
public class InCartProductDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public InCartProduct selectInCartProductById(long inCartProductId) {
        return entityManager.find(InCartProduct.class, inCartProductId);
    }
 
    public void insertInCartProduct(InCartProduct inCartProduct) {
        entityManager.persist(inCartProduct);
    }
 
    public void updateInCartProduct(InCartProduct inCartProduct) {
        InCartProduct inCartProductToUpdate = selectInCartProductById(inCartProduct.getInCartProductId());
        inCartProductToUpdate.setFkUserId(inCartProduct.getFkUserId());
        inCartProductToUpdate.setFkProductId(inCartProduct.getFkProductId());
        inCartProductToUpdate.setCreatedAt(inCartProduct.getCreatedAt());
        inCartProductToUpdate.setUpdatedAt(inCartProduct.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteInCartProduct(long inCartProductId) {
        entityManager.remove(selectInCartProductById(inCartProductId));
    }

    @SuppressWarnings("unchecked")
    public List<InCartProduct> selectAllInCartProducts() {
        Query query = entityManager.createQuery("FROM InCartProduct AS ICP ORDER BY ICP.inCartProductId ASC");
        return (List<InCartProduct>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectNumberOfRecordsInInCartProductTable() {
        Query query = entityManager.createQuery("SELECT COUNT(*) AS numberOfRecords FROM InCartProduct");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectInCartProductIdOfLastRecord() {
        Query query = entityManager.createQuery("SELECT MAX(inCartProductId) as lastInsertedInCartProductId  FROM InCartProduct");
        return (List<Long>) query.getResultList();
    }
 
}
