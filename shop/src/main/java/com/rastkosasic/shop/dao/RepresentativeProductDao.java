package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.RepresentativeProduct;
 
@Repository("representativeProductDao")
public class RepresentativeProductDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public RepresentativeProduct selectRepresentativeProductById(long representativeProductId) {
        return entityManager.find(RepresentativeProduct.class, representativeProductId);
    }
 
    public void insertRepresentativeProduct(RepresentativeProduct representativeProduct) {
        entityManager.persist(representativeProduct);
    }
 
    public void updateRepresentativeProduct(RepresentativeProduct representativeProduct) {
 
        RepresentativeProduct representativeProductToUpdate = selectRepresentativeProductById(representativeProduct.getRepresentativeProductId());
 
        representativeProductToUpdate.setFkProductId(representativeProduct.getRepresentativeProductId());
        representativeProductToUpdate.setCreatedAt(representativeProduct.getCreatedAt());
        representativeProductToUpdate.setUpdatedAt(representativeProduct.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteRepresentativeProduct(long representativeProductId) {
        entityManager.remove(selectRepresentativeProductById(representativeProductId));
    }
 

    @SuppressWarnings("unchecked")
    public List<RepresentativeProduct> selectAllRepresentativeProducts() {
        Query query = entityManager.createQuery("FROM RepresentativeProduct AS RP ORDER BY RP.representativeProductId ASC");
        return (List<RepresentativeProduct>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectNumberOfRecordsInRepresentativeProductTable() {
        Query query = entityManager.createQuery("SELECT COUNT(*) AS numberOfRecords FROM RepresentativeProduct");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectRepresentativeProductIdOfLastRecord() {
        Query query = entityManager.createQuery("SELECT MAX(representativeProductId) as lastInsertedRepresentativeProductId  FROM RepresentativeProduct");
        return (List<Long>) query.getResultList();
    }
 
}
