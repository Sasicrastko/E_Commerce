package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.Size;
 
@Repository("sizeDao")
public class SizeDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public Size selectSizeById(long sizeId) {
        return entityManager.find(Size.class, sizeId);
    }
 
    public void insertSize(Size size) {
        entityManager.persist(size);
    }
 
    public void updateSize(Size size) {
        Size sizeToUpdate = selectSizeById(size.getSizeId());
        sizeToUpdate.setSizeName(size.getSizeName());
        sizeToUpdate.setCreatedAt(size.getCreatedAt());
        sizeToUpdate.setUpdatedAt(size.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteSize(long sizeId) {
        entityManager.remove(selectSizeById(sizeId));
    }
 

    @SuppressWarnings("unchecked")
  public List<Size> selectAllSizes() {
        Query query = entityManager.createQuery("FROM Size AS t ORDER BY t.sizeName ASC");
        return (List<Size>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
  public List<Long> selectNumberOfRecordsInSizeTable() {
        Query query = entityManager.createQuery("SELECT COUNT(*) AS numberOfRecords FROM Size");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
  public List<Long> selectSizeIdOfLastRecord() {
        Query query = entityManager.createQuery("SELECT MAX(sizeId) as lastInsertedSizeId  FROM Size");
        return (List<Long>) query.getResultList();
    }
 
}
