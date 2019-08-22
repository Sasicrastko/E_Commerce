package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.Attribute;
 
@Repository("attributeDao")
public class AttributeDao {
 
    @PersistenceContext
    private EntityManager entityManager; 
 
    public Attribute selectAttributeById(long attributeId) {
        return entityManager.find(Attribute.class, attributeId);
    }
 
    public void insertAttribute(Attribute attribute) {
        entityManager.persist(attribute);
    }
 
    public void updateAttribute(Attribute attribute) {
 
        Attribute attributeToUpdate = selectAttributeById(attribute.getAttributeId());
 
        attributeToUpdate.setColor(attribute.getColor());
        attributeToUpdate.setQuantity(attribute.getQuantity());
        attributeToUpdate.setFkSizeId(attribute.getFkSizeId());
        attributeToUpdate.setFkProductId(attribute.getFkProductId());
        attributeToUpdate.setCreatedAt(attribute.getCreatedAt());
        attributeToUpdate.setUpdatedAt(attribute.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteAttribute(long tagId) {
        entityManager.remove(selectAttributeById(tagId));
    }
 
    @SuppressWarnings("unchecked")
    public List<Attribute> selectAllAttributes() {
        Query query = entityManager.createQuery("FROM Attribute AS att ORDER BY att.attributeId");
        return (List<Attribute>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectNumberOfRecordsInAttributeTable() {
        Query query = entityManager.createQuery("SELECT COUNT(*) AS numberOfRecords FROM Attribute");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> selectAttributeIdOfLastRecord() {
        Query query = entityManager.createQuery("SELECT MAX(attributeId) AS lastInsertedAttributeId  FROM Attribute");
        return (List<Long>) query.getResultList();
    }
 
}
